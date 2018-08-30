package com.fecklefacemassive.www.education.MongoApp.pojo;

public class AnimeReview {

    public String reviewer;

    public String review;

    public int score;

    public AnimeReview() {
        super();
    }

    public AnimeReview (String reviewer, String review, int score) {
        this.reviewer = reviewer;
        this.review = review;
        this.score = score;
    }

}
