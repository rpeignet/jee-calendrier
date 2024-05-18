package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.Theme;
import fr.esgi.calendrier_ybr_rpt.exception.MissingParamException;
import fr.esgi.calendrier_ybr_rpt.exception.utilisateur.ThemeNotFoundException;
import fr.esgi.calendrier_ybr_rpt.repository.ThemeRepository;
import fr.esgi.calendrier_ybr_rpt.service.ThemeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ThemeServiceImpl implements ThemeService {
    private ThemeRepository themeRepository;

    @Override
    public Theme findById(Long id) {
        if(id != null){
            Optional<Theme> theme = this.themeRepository.findById(id);
            if(theme.isPresent()){
                return theme.get();
            }else{
                throw new ThemeNotFoundException();
            }
        }else{
            throw new MissingParamException();
        }
    }

    @Override
    public List<Theme> findAllForSelection(){
        List<Theme> themes = themeRepository.findAll();
        themes.add(0, new Theme("Merci de choisir un thème"));
        return themes;
    }
}
