package com.security.repo;

import com.security.model.Anime;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimeRepo extends JpaRepository<Anime, Integer> {
    @Query("SELECT a FROM Anime a WHERE a.user.id = :userId")
    List<Anime> findAllAnimeByUser(Integer userId);

    @Query("SELECT a FROM Anime a WHERE a.user.id = :userId AND a.id = :animeId")
    Anime findAnimeByUserAndId(Integer userId, Integer animeId);

    @Modifying
    @Transactional
    @Query("DELETE FROM Anime a WHERE a.id = :animeId AND a.user.id = :userId")
    void deleteAnimeByUserAndId(Integer userId, Integer animeId);
}
