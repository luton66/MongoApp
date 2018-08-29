package com.fecklefacemassive.www.education.MongoApp.Dao;

import com.fecklefacemassive.www.education.MongoApp.pojo.AnimeDetails;

import java.util.List;

/**
 * The AnimeBaseRepository that has been constructed is an interface (where Spring ensures no Impl class is required),
 * that extends MongoRepository (and therefore doesn't seem to use MongoTemplate). So a new interface has been created
 * that doesn't extend MongoRepository.
 *
 * Next refer to CustomAnimeDetailsRepoImpl to see comments made there.
 */
public interface CustomAnimeDetailsRepo {

    public List<AnimeDetails> testSpecific();
}
