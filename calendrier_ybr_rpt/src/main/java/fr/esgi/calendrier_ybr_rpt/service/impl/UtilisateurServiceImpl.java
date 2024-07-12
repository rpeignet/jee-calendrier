package fr.esgi.calendrier_ybr_rpt.service.impl;

import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.exception.MissingParamException;
import fr.esgi.calendrier_ybr_rpt.exception.utilisateur.UtilisateurNotFoundException;
import fr.esgi.calendrier_ybr_rpt.repository.UtilisateurRepository;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import jakarta.validation.Validator;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UtilisateurServiceImpl implements UtilisateurService {
    private UtilisateurRepository utilisateurRepository;
    private InMemoryUserDetailsManager inMemoryUserDetailsManager;
    private PasswordEncoder passwordEncoder;
    private Validator validator;

    @Override
    public Utilisateur save(Utilisateur utilisateur){
        Set<ConstraintViolation<Utilisateur>> violations = validator.validate(utilisateur);

        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Utilisateur> violation : violations) {
                sb.append(violation.getMessage());
            }
            throw new ValidationException(sb.toString());
        }

        utilisateur.setNombreDePoint(500);
        UserDetails newUser = User.builder().username(utilisateur.getEmail())
                .password(passwordEncoder.encode(utilisateur.getMotDePasse()))
                .roles("USER")
                .build();
        inMemoryUserDetailsManager.createUser(newUser);
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur findById(Long id) {
        if(id != null){
            Optional<Utilisateur> utilisateur = utilisateurRepository.findById(id);
            if(utilisateur.isPresent()){
                return utilisateur.get();
            }else{
                throw new UtilisateurNotFoundException();
            }
        }else{
            throw new MissingParamException();
        }
    }

    @Override
    public Utilisateur findByEmail(String email) {
        return utilisateurRepository.findByEmail(email);
    }
}
