package com.fecklefacemassive.www.education.MongoApp.TempUtilities;

import com.fecklefacemassive.www.education.MongoApp.Dao.AnimeBaseRepository;
import com.fecklefacemassive.www.education.MongoApp.Dao.BallsRepo;
import com.fecklefacemassive.www.education.MongoApp.pojo.AnimeDetails;
import com.fecklefacemassive.www.education.MongoApp.pojo.AnimeReview;
import com.fecklefacemassive.www.education.MongoApp.pojo.Balls;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * The purpose of this class is to use CommandLineRunner and a run() method which will make this class execute at the
 * moment SpringBoot is up and running.
 *
 * This deletes all of the informations in AnimeBaseRepository and then repopulates it with provided values
 *
 * There is also a BallsRepo that is used. Further JavaDoc comments will be added for that below
 */
@Component
public class SeedUtil implements CommandLineRunner{

    AnimeBaseRepository repository;
    BallsRepo ballsRepo;

    public SeedUtil (AnimeBaseRepository repository, BallsRepo ballsRepo) {
        this.repository = repository;
        this.ballsRepo = ballsRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        AnimeDetails konosuba = new AnimeDetails("Konosuba");
        konosuba.company = "unknown";
        konosuba.description = "Fun Stuff";
        konosuba.reviews = Arrays.asList(
                new AnimeReview("Leigh", "This is great!", 9),
                new AnimeReview("Jamo", "Also think this is the shiz!", 9)
        );

        AnimeDetails wagnaria = new AnimeDetails("Wagnaria");
        wagnaria.company = "unknown";
        wagnaria.description = "Fun Cafe Stuff";
        wagnaria.reviews = Arrays.asList(
                new AnimeReview("Leigh", "Aww! So Nice", 10),
                new AnimeReview("Jamo", "Dawg! Bra Bra Bra!", 9)
        );

        AnimeDetails mechAssault = new AnimeDetails("MechAssault");
        mechAssault.company = "unknown";
        mechAssault.description = "Crap Mech Stuff";
        mechAssault.reviews = Arrays.asList(
                new AnimeReview("Leigh", "Boring!", 5),
                new AnimeReview("Jamo", "Shit! Bra Bra Bra!", 3)
        );

        this.repository.deleteAll();

        List<AnimeDetails> myList = Arrays.asList(konosuba, wagnaria, mechAssault);
        this.repository.saveAll(myList);

        /*
        The purpose of the Balls Repo is to show that when the above AnimeBaseRepository is called upon to deleteAll,
        it will not actually delete the entire contents of the AnimeDB, but instead the AnimeBaseRepository will see
        that it extends MongoRepository<AnimeDetails, String> and AnimeDetails has a document Annotation to link it to
        the AnimeInfo database.
         */

        //The following lines can be incommented to carry out the above test.
        this.ballsRepo.deleteAll();
        this.populateBallsRepo();
    }

    /**
     * This  method is simply used to repopulate the BallsRepo with some values after it has been deleted above.
     *
     * This is only done for test purposes.
     */
    private void populateBallsRepo() {
        Balls ball1 = new Balls();
        Balls ball2 = new Balls();

        ball1.ballName = "Terry";
        ball1.ballType = "Tennis Ball";
        ball2.ballName = "Fredderick";
        ball2.ballType = "Football";

        List<Balls> ballList = Arrays.asList(ball1, ball2);

        this.ballsRepo.saveAll(ballList);
    }
}
