package com.security.controller;

import com.security.model.Anime;
import com.security.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/anime")
public class AnimeController {
    @Autowired
    private AnimeService animeService;

    @GetMapping("/all")
    public List<Anime> getAllAnime() {
        return animeService.getAllAnime();
    }

    @GetMapping("/{id}")
    public Anime getAnimeById(@PathVariable Integer id) {
        return animeService.getAnimeById(id);
    }

    @PostMapping("/")
    public Anime addAnime(@RequestBody Anime anime) {
        return animeService.addAnime(anime);
    }

    @PutMapping("/{id}")
    public Anime updateAnimeById(@PathVariable Integer id, @RequestBody Anime anime) {
        return animeService.updateAnimeById(id, anime);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimeById(@PathVariable Integer id) {
        animeService.deleteAnimeById(id);
    }
}