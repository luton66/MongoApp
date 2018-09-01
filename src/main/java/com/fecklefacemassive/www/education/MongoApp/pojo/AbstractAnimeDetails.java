package com.fecklefacemassive.www.education.MongoApp.pojo;

import java.util.List;

public abstract class AbstractAnimeDetails {
    public String title;

    public String company;

    public String description;

    public List<AnimeReview> reviews;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AnimeReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<AnimeReview> reviews) {
        this.reviews = reviews;
    }
}
