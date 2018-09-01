package com.fecklefacemassive.www.education.MongoApp.Dao;

import com.fecklefacemassive.www.education.MongoApp.pojo.AnimeDetails;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

/**
 * This is just a MongoTemplate test class, see seperate branch for full documentation
 */
public class CustomAnimeRepoImpl implements CustomAnimeRepo{

    private MongoTemplate mongoTemplate;

    public CustomAnimeRepoImpl(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<AnimeDetails> mongoTemplateSpecificTest() {
        Query query = new Query();
        query.addCriteria(Criteria.where("title").is("Konosuba"));

        List<AnimeDetails> result = mongoTemplate.find(query, AnimeDetails.class);
        return result;
    }
}
