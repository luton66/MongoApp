package com.fecklefacemassive.www.education.MongoApp.RestControllers;

import com.fecklefacemassive.www.education.MongoApp.Dao.AnimeBaseRepository;
import com.fecklefacemassive.www.education.MongoApp.pojo.AnimeDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/anime")

public class AnimeDetailsRest {

    private AnimeBaseRepository animeBaseRepository;

    public AnimeDetailsRest(AnimeBaseRepository animeBaseRepository) {
        this.animeBaseRepository = animeBaseRepository;
    }

    @GetMapping("/")
    public List<AnimeDetails> displayAll() {
        List<AnimeDetails> allAnime = animeBaseRepository.findAll();

        return allAnime;
    }

}
