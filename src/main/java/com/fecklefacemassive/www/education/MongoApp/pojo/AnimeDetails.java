package com.fecklefacemassive.www.education.MongoApp.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AnimeInfo")
public class AnimeDetails extends AbstractAnimeDetails {

    @Id
    public String id;
}
