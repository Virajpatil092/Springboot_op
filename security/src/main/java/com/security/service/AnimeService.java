package com.security.service;

import com.security.model.Anime;
import com.security.model.User;
import com.security.repo.AnimeRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import java.util.List;
import java.util.Optional;

@Service
public class AnimeService {
    private final AnimeRepo animeRepo;
    private final JwtService jwtService;

    public AnimeService(AnimeRepo animeRepo, JwtService jwtService) {
        this.animeRepo = animeRepo;
        this.jwtService = jwtService;
    }

    public List<Anime> getAllAnime() {
        User user = getUserFromToken();
        return user != null ? animeRepo.findAllAnimeByUser(user.getId()) : List.of();
    }

    public Anime getAnimeById(Integer animeId) {
        User user = getUserFromToken();
        return user != null ? animeRepo.findAnimeByUserAndId(user.getId(), animeId) : null;
    }

    public void deleteAnimeById(Integer animeId) {
        User user = getUserFromToken();
        if (user != null) {
            animeRepo.deleteAnimeByUserAndId(user.getId(), animeId);
        }
    }

    public Anime updateAnimeById(Integer animeId, Anime anime) {
        User user = getUserFromToken();
        if (user != null) {
            Optional<Anime> animeToUpdateOpt = animeRepo.findById(animeId);
            if (animeToUpdateOpt.isPresent() && animeToUpdateOpt.get().getUser().getId().equals(user.getId())) {
                Anime animeToUpdate = animeToUpdateOpt.get();
                animeToUpdate.setName(anime.getName());
                animeToUpdate.setGenre(anime.getGenre());
                return animeRepo.save(animeToUpdate);
            }
        }
        return null;
    }

    public Anime addAnime(Anime anime) {
        User user = getUserFromToken();
        if (user != null) {
            anime.setUser(user);
            return animeRepo.save(anime);
        }
        return null;
    }

    private User getUserFromToken() {
        String token = getTokenFromHeader();
        return token != null ? jwtService.extractUser(token) : null;
    }

    private String getTokenFromHeader() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }
}
