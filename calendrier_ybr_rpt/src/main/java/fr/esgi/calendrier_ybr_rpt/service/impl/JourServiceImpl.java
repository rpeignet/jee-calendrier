package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.Jour;
import fr.esgi.calendrier_ybr_rpt.exception.MissingParamException;
import fr.esgi.calendrier_ybr_rpt.exception.jour.JourNotFoundException;
import fr.esgi.calendrier_ybr_rpt.repository.JourRepository;
import fr.esgi.calendrier_ybr_rpt.service.JourService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JourServiceImpl implements JourService {

    private JourRepository jourRepository;

    @Override
    public Page<Jour> findAll(Pageable pageable) {
        return jourRepository.findAll(pageable);
    }

    @Override
    public Jour findById(Long id) {
        if(id != null){
            Optional<Jour> jour = jourRepository.findById(id);
            if(jour.isPresent()){
                return jour.get();
            }else{
                throw new JourNotFoundException();
            }
        }else{
            throw new MissingParamException();
        }
    }
}
