package fr.esgi.calendrier_ybr_rpt;

import fr.esgi.calendrier_ybr_rpt.repository.JourRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.YearMonth;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class DonneesInitialesTest {
    @Autowired
    private JourRepository jourRepository;

    @Test
    @Order(1)
    void shouldImportDayOfMounth(){
        // L'application intialise les jours du mois en cours en base de donnée H2
        int jourMoisEnCours = YearMonth.now().lengthOfMonth();
        assert jourRepository.count() == jourMoisEnCours;
    }
}
