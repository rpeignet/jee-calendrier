package fr.esgi.calendrier_ybr_rpt.controller.rest;

import fr.esgi.calendrier_ybr_rpt.business.Gif;
import fr.esgi.calendrier_ybr_rpt.dto.in.GifCreationDTO;
import fr.esgi.calendrier_ybr_rpt.mapper.GifMapper;
import fr.esgi.calendrier_ybr_rpt.service.GifService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/gifs")
@AllArgsConstructor
public class GifRestController {
    private GifService gifService;
    private GifMapper gifMapper;

    @PostMapping("")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Gif placer(@RequestBody GifCreationDTO gifCreationDTO){
        return gifService.save(gifMapper.toEntity(gifCreationDTO), null);
    }

    @PostMapping("/televerser")
    @ResponseStatus(code= HttpStatus.CREATED)
    public Gif televerser(@RequestBody GifCreationDTO gifCreationDTO, @RequestParam("file") MultipartFile file){
        return gifService.save(gifMapper.toEntity(gifCreationDTO), file);
    }
}
