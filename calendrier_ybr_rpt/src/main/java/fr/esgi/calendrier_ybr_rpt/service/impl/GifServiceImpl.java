package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.Gif;
import fr.esgi.calendrier_ybr_rpt.repository.GifRepository;
import fr.esgi.calendrier_ybr_rpt.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GifServiceImpl implements GifService {
    private GifRepository gifRepository;

    @Override
    public Gif save(Gif gif) {
        // TODO : voir comment si on reste sur des valeur de jour aléatoire ?
        int nombreDePointUtilisateur = gif.getUtilisateur().getNombreDePoint();
        int valeurJour = gif.getJour().getValeur();
        gif.getUtilisateur().setNombreDePoint(nombreDePointUtilisateur - valeurJour);
        return gifRepository.save(gif);
    }
}
