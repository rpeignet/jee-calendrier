package fr.esgi.calendrier_ybr_rpt;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.esgi.calendrier_ybr_rpt.business.Utilisateur;
import fr.esgi.calendrier_ybr_rpt.dto.in.GifCreationDTO;
import fr.esgi.calendrier_ybr_rpt.dto.in.UtilisateurCreationDTO;
import fr.esgi.calendrier_ybr_rpt.exception.gif.GifAllreadyExistException;
import fr.esgi.calendrier_ybr_rpt.mapper.UtilisateurMapper;
import fr.esgi.calendrier_ybr_rpt.repository.UtilisateurRepository;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class GifRestControllerIT {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Order(1)
    void shouldPutGifOnDay() throws Exception{
        GifCreationDTO gif = new GifCreationDTO();
        gif.idUtilisateur = 1L;
        gif.urlFichier = "https://c.tenor.com/uxRYtAqtMfgAAAAC/tenor.gif";
        gif.legende = "Sympa force";
        gif.idJour = 3L;


        String url = "/api/gifs";
        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(gif)))
                .andExpect(status().isCreated());
    }

    @Test
    @Order(2)
    void shouldReturnGifAlreadyExistException() throws Exception {
        GifCreationDTO gif = new GifCreationDTO();
        gif.idUtilisateur = 1L;
        gif.urlFichier = "https://c.tenor.com/uxRYtAqtMfgAAAAC/tenor.gif";
        gif.legende = "Sympa force";
        gif.idJour = 4L;

        String url = "/api/gifs";
        mockMvc.perform(post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(gif)));

        mockMvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(gif)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    assertThat(result.getResolvedException()).isInstanceOf(GifAllreadyExistException.class);
                });
    }
}
