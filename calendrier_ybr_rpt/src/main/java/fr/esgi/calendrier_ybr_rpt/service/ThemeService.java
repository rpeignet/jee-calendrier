package fr.esgi.calendrier_ybr_rpt.service;

import fr.esgi.calendrier_ybr_rpt.business.Theme;

import java.util.List;

public interface ThemeService {
    public Theme findById(Long id);
    public List<Theme> findAllForSelection();
}
