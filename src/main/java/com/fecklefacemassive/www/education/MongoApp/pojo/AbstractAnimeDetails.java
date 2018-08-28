package com.fecklefacemassive.www.education.MongoApp.pojo;

import java.util.List;

public abstract class AbstractAnimeDetails {
    public String title;

    public String company;

    public String description;

    public List<AnimeReview> reviews;

    public AbstractAnimeDetails() {
        super();
    }

    public AbstractAnimeDetails(String title) {
        this.title = title;
    }

    public AbstractAnimeDetails(String title, String company, String description, List<AnimeReview> reviews) {
        this(title);
        this.company = company;
        this.description = description;
        this.reviews = reviews;
    }
}
