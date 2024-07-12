package fr.esgi.calendrier_ybr_rpt.configuration;

import fr.esgi.calendrier_ybr_rpt.handler.LoginFailureHandler;
import fr.esgi.calendrier_ybr_rpt.handler.LoginSuccessHandler;
import fr.esgi.calendrier_ybr_rpt.service.UtilisateurService;
import fr.esgi.calendrier_ybr_rpt.service.impl.UserConnectedService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

    private UtilisateurService utilisateurService;
    private UserConnectedService userConnectedService;
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable).formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .successHandler(new LoginSuccessHandler(userConnectedService, utilisateurService))
                .failureHandler(new LoginFailureHandler())
        ).authorizeHttpRequests(requests ->
                                requests.requestMatchers("/swagger-ui/**", "/v2/api-docs/**", "/v3/api-docs/**", "/swagger-resources/**", "/swagger-ui.html").permitAll()
                                        .requestMatchers("/utilisateur/**").permitAll()
                                        .requestMatchers("/main-dark.css").permitAll()
                                        .requestMatchers("/main-light.css").permitAll()
                                        .requestMatchers("/style-calendrier/**").permitAll()
                                        .requestMatchers("/").permitAll()
                                        .requestMatchers("/login").permitAll()
                                        .requestMatchers("/signin").permitAll()
                                        .requestMatchers("/form-signin").permitAll()

                                        .requestMatchers("/calendrier").authenticated()
                                        .requestMatchers("/calendrier/**").authenticated()

                                        .requestMatchers("/gifs/**").authenticated()
                                        .requestMatchers("/gifs-files/**").authenticated()

                                        // Pour faciliter les tests avec insomnia
                                        .requestMatchers("/api/**").permitAll()

                )
                .headers(header -> header.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable));
        return http.build();
    }
}
