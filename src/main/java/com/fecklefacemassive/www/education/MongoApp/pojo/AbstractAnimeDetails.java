package com.fecklefacemassive.www.education.MongoApp.pojo;

import java.util.List;

public abstract class AbstractAnimeDetails {
    public String id;

    public String title;

    public String company;

    public String description;

    public List<AnimeReview> reviews;

    AbstractAnimeDetails(String title) {
        this.title = title;
    }
}
