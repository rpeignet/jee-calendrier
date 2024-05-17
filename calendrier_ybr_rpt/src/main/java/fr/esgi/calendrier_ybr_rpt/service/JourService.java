package fr.esgi.calendrier_ybr_rpt.service;

import fr.esgi.calendrier_ybr_rpt.business.Jour;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JourService {
    public Page<Jour> findAll(Pageable pageable);
    public Jour findById(Long id);
}
