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
        // TODO : voir comment sont gérer le nombre de point par jour ?
        int nombreDePoint = gif.getUtilisateur().getNombreDePoint();
        gif.getUtilisateur().setNombreDePoint(nombreDePoint - 30);
        return gifRepository.save(gif);
    }

    @Override
    public Gif findById(Long id) {
        return null;
    }
}
