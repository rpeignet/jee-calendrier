package fr.esgi.calendrier_ybr_rpt.service;

import fr.esgi.calendrier_ybr_rpt.business.Gif;
import org.springframework.web.multipart.MultipartFile;

public interface GifService {
    public Gif save(Gif gif, MultipartFile multipartFile);

    public Gif findById(Long id);
}
