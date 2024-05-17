package fr.esgi.calendrier_ybr_rpt.service;

import fr.esgi.calendrier_ybr_rpt.business.Gif;

public interface GifService {
    public Gif save(Gif gif);
    public Gif findById(Long id);
}
