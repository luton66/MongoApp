package com.fecklefacemassive.www.education.MongoApp.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AnimeInfo")
public class AnimeDetails extends AbstractAnimeDetails {

    @Id
    public String id;

    public AnimeDetails() {
        super();
    }

    /**
     * This constructor is required for the SeedUtil which actually calls upon a constructor with a title argument
     * @param title the title of the Anime
     */
    public AnimeDetails(String title) {
        super();
        this.title = title;
    }

}
