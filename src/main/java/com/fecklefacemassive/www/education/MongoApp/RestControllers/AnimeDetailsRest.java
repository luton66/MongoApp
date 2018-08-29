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

    /**
     * This is a more complicated filter, as score is in a nested object 'reviews' within AnimeDetails. To do this
     * a @Query annotation is defined in AnimeBaseRepository with the required mongo query.
     *
     * @param score the score to search by
     * @return a list fo AnimeDetails that match the score.
     */
    @GetMapping("/score/{score}")
    public List<AnimeDetails> findByScore(@PathVariable("score") int score) {
        List<AnimeDetails> animeDetails = this.animeBaseRepository.findByScore(score);

        return animeDetails;
    }

    @GetMapping("/minscore/{score}")
    public List<AnimeDetails> findByMinScore(@PathVariable("score") int score) {
        List<AnimeDetails> animeDetails = this.animeBaseRepository.findMinScore(score);

        return animeDetails;
    }

    /**
     * This is just a bullshit Mapping to use, as I was simply carrying out a test. This method calls on
     * animeBaseRepository.testSpecific. However, where this class has been able to determine which Collection to write
     * to using the @Document annotation on AnimeDetails - found in extends MongoRepository<AnimeDetails, .... - the
     * method below is actually going to CustomAnimeDetailsRepoImpl, which uses the older MongoTemplate method of
     * building a query.
     *
     * Make sure to check AnimeBaseRepository for more comments.
     *
     * @return doesn't matter.
     */
    @GetMapping("/wildtest")
    public List<AnimeDetails> testRun() {
        List<AnimeDetails> animeDetails = this.animeBaseRepository.testSpecific();

        return animeDetails;
    }


}
