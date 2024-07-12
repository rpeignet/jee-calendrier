package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.Gif;
import fr.esgi.calendrier_ybr_rpt.exception.MissingParamException;
import fr.esgi.calendrier_ybr_rpt.exception.gif.*;
import fr.esgi.calendrier_ybr_rpt.repository.GifRepository;
import fr.esgi.calendrier_ybr_rpt.service.GifService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GifServiceImpl implements GifService {
    private GifRepository gifRepository;
    private final String defaultPath = "target/classes/static/gifs-files";
    @Override
    public Gif save(Gif gif, MultipartFile file){
        if(gif.getJour() != null && gif.getJour().getGif() == null){
            checkGifValue(gif);
            if(file != null){
                if(file.getContentType() != null && file.getContentType().equals("image/gif")){
                    gif.setFileName(downloadGif(file));
                }else{
                    throw new GifFileFormatException();
                }
            }else{
                gif.setFileName(downloadGif(gif.getUrlFichier()));
            }
            return gifRepository.save(gif);
        }else{
            throw new GifAlreadyExistException();
        }
    }

    @Override
    public Gif findById(Long id) {
        if(id != null){
            Optional<Gif> gif = gifRepository.findById(id);
            if(gif.isPresent()){
                return gif.get();
            }else{
                throw new GifNotFoundException();
            }
        }else {
            throw new MissingParamException();
        }
    }

    /*
     * Vérifie que le nombre de point de l'utilisateur
     * est suppérieur au nombre de point de la valeur du gif
     * Et retire le nombre de point de la valeur du gif à l'utilisateur
     * */
    private void checkGifValue(Gif gif){
        int nombreDePointUtilisateur = gif.getUtilisateur().getNombreDePoint();
        int valeurJour = gif.getJour().getValeur();
        if(nombreDePointUtilisateur > valeurJour){
            gif.getUtilisateur().setNombreDePoint(nombreDePointUtilisateur - valeurJour);
        }else{
            throw new UtilisateurCreditException();
        }
    }

    private String downloadGif(String url){
        try{
            String fileName = UUID.randomUUID().toString() + ".gif";
            File fichierGif = new File(defaultPath + File.separator + fileName);
            FileUtils.copyURLToFile(new URL(url), fichierGif);
            return fichierGif.getName();
        }catch (Exception e){
            throw new GifDownloadException();
        }
    }

    private String downloadGif(MultipartFile file) {
        if (file.isEmpty()) {
            throw new GifDownloadException();
        }
        try {
            String fileName = UUID.randomUUID().toString() + ".gif";
            Path filePath = Paths.get(defaultPath + File.separator + fileName);
            Files.write(filePath, file.getBytes());
            return fileName;
        } catch (Exception e) {
            throw new GifDownloadException();
        }
    }
}
