package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.Gif;
import fr.esgi.calendrier_ybr_rpt.repository.GifRepository;
import fr.esgi.calendrier_ybr_rpt.service.GifService;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GifServiceImpl implements GifService {
    private GifRepository gifRepository;
    private final String defaultPath = "target/classes/static/gifs-files";

    @Override
    public Gif save(Gif gif) {
        // TODO : voir si on reste sur des valeurs de jour aléatoire ?
        int nombreDePointUtilisateur = gif.getUtilisateur().getNombreDePoint();
        int valeurJour = gif.getJour().getValeur();
        if(gif.getJour() != null && gif.getJour().getGif() == null){
            if(nombreDePointUtilisateur > valeurJour){
                gif.setFileName(downloadGif(gif.getUrlFichier()));
                gif.getUtilisateur().setNombreDePoint(nombreDePointUtilisateur - valeurJour);
                return gifRepository.save(gif);
            }else{
                throw new RuntimeException("L'utilisateur n'a pas assez de points");
            }
        }else{
            throw new RuntimeException("Le jour choisi contient déjà un gif");
        }
    }

    @Override
    public Gif findById(Long id) {
        if(id != null){
            Optional<Gif> gif = gifRepository.findById(id);
            if(gif.isPresent()){
                return gif.get();
            }else{
                throw new RuntimeException("Le gif demandé n'existe pas");
            }
        }else {
            throw new RuntimeException("Un id doit être renseigné");
        }
    }

    private String downloadGif(String url){
        try{
            String fileName = UUID.randomUUID().toString() + ".gif";
            File fichierGif = new File(defaultPath + File.separator + fileName);
            FileUtils.copyURLToFile(new URL(url), fichierGif);
            return fichierGif.getName();
        }catch (Exception e){
            throw new RuntimeException("Erreur lors du téléchargement du fichier GIF");
        }
    }
}
