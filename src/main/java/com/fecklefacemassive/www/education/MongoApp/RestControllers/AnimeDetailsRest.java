package com.fecklefacemassive.www.education.MongoApp.RestControllers;

import com.fecklefacemassive.www.education.MongoApp.Dao.AnimeBaseRepository;
import com.fecklefacemassive.www.education.MongoApp.pojo.AnimeDetails;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping
    public void addAnime(@RequestBody AnimeDetails animeDetails) {
        animeBaseRepository.insert(animeDetails);
    }

    @PostMapping
    public void updateAnime (@RequestBody AnimeDetails animeDetails) {
        animeBaseRepository.save(animeDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteAnime (@PathVariable("id") String id) {
        animeBaseRepository.deleteById(id);
    }

    /**
     * Don't really know how this works, but simply by having a method 'findByTitle' it knows how to
     * filter for that field. Apart from a line in the AnimeBaseRepository interface, there is no other
     * programming added.
     *
     * @param title the title to search for
     * @return a matching title.
     */
    @GetMapping("/title/{title}")
    public AnimeDetails findByTitle(@PathVariable("title") String title) {
        AnimeDetails animeDetails = this.animeBaseRepository.findByTitle(title);

        return animeDetails;
    }

}
