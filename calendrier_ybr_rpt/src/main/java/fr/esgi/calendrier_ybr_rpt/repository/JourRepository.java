package fr.esgi.calendrier_ybr_rpt.repository;

import fr.esgi.calendrier_ybr_rpt.business.Jour;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourRepository extends JpaRepository<Jour, Long> {
}
