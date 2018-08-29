package com.fecklefacemassive.www.education.MongoApp.Dao;

import com.fecklefacemassive.www.education.MongoApp.pojo.AnimeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This interface, which is used by AnimeDetailsRest now extends BOTH MongoRepository<AnimeDetails, String> AND
 * CustomAnimeDetailsRepo. This is a temporary implementation to run a test. By doing this, the use of MonogRepository
 * allows Spring to check the AnimeDetails object in MongoRepository<AnimeDetails...etc> and use the @Document
 * annotation to know where to write and read the Mongo request to/from. But by also using CustomAnimeDetailsRepo, it
 * will be able to call upon the queries used by CustomAnimeDetailsRepoImpl which implements it.
 *
 * That class uses MongoTemplate and Query builders instead of Query Annotations. This is simply showing how
 * both MongoTemplate and MongoRepository with @Query annotations can be used together in the SAME Rest Controller.
 */
@Repository
public interface AnimeBaseRepository extends MongoRepository<AnimeDetails, String>, CustomAnimeDetailsRepo {

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

    @Query(value = "{'reviews.score': { $gte: ?0 } }")
    List<AnimeDetails> findMinScore(int score);
}
