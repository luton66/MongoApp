package com.fecklefacemassive.www.education.MongoApp.pojo;

import java.util.List;

public abstract class AbstractAnimeDetails implements AbstractAnimeRecord {
    public String title;

    public String company;

    public String description;

    public List<AnimeReview> reviews;
}
