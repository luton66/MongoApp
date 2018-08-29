package com.fecklefacemassive.www.education.MongoApp.Dao.AnimeDetailsRetrieval;

import com.fecklefacemassive.www.education.MongoApp.Dao.CustomAnimeDetailsRepo;
import com.fecklefacemassive.www.education.MongoApp.pojo.AnimeDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * This implements CustomAnimeDetailsRepo interface. This has been done as CustomAnimeDetailsRepo will also be used
 * in AnimeDetailsRest. By Autowiring in the MongoTemplate, this will retrieve the details for the database
 * connection from application.properties. In regards to which Collection to use, this seems to be done as such...
 *
 * The AnimeBaseRepository which extends MongoRepository, will also extend this. The MongoRepository<AnimeDetails,...>
 * part will still tell the AnimeBaseRepository which Collection to connect to through the @Document annotaion on
 * AnimeDetails.
 * Any method in this class, will also be called through AnimeBaseRepository, so the connection to the correct
 * Document will still be maintained. But as the method will route to this implementation, MongoTemplate will be used.
 *
 * You may need to refer to these...
 * https://stackoverflow.com/questions/19583540/spring-data-jpa-no-property-found-for-type-exception
 * and
 * https://dzone.com/articles/persistence-layer-spring-data
 *
 * As these both highlight a problem I was having. Because this class was originally called something else, it confused
 * Spring, which thought that testSpecific was supposed to be a property of AnimeDetails. Fucking around with it for
 * a while seemed to fix it.
 *
 * AnimeDetailsRest.class has more.
 */
public class CustomAnimeDetailsRepoImpl implements CustomAnimeDetailsRepo {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<AnimeDetails> testSpecific() {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is("Konosuba"));
        //This criteria will return a response
        query.addCriteria(Criteria.where("company").is("unknown"));
        //This criteria will return no response
        //query.addCriteria(Criteria.where("company").is("bubbly"));
        List<AnimeDetails> results = mongoTemplate.find(query, AnimeDetails.class);

        return results;
    }
}
