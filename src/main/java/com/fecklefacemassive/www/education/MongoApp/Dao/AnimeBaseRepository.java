package com.fecklefacemassive.www.education.MongoApp.Dao;

import com.fecklefacemassive.www.education.MongoApp.pojo.AnimeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This class now implements the Interface CustomAnimeRepo as part of a MongoTemplate test. It is not actually required
 * See seperate branch for further docs.
 */
@Repository
public interface AnimeBaseRepository extends MongoRepository<AnimeDetails, String>, CustomAnimeRepo {

    AnimeDetails findByTitle(String title);

    /**
     * This is more complicated that other queries because the score is in a nested object called Reviews.
     * So, it will not just work out the box, and instead will require a mongo query defined in a
     * query param.
     *
     * @param score the score
     * @return a List of AnimeDetails that match the score
     */
    @Query(value = "{'reviews.score':?0}")    //the ?0 refers to the parameter, which in this case is the score
    List<AnimeDetails> findByScore(int score);

    /**
     * Similar to above, but finds by minimum score.
     *
     * @param score the minimum score to be filtered by
     * @return a List of AnimeDetails with a score greater to or equal the above
     */
    @Query(value = "{'reviews.score': { $gte: ?0 } }")
    List<AnimeDetails> findMinScore(int score);
}
