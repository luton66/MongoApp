package com.fecklefacemassive.www.education.MongoApp;

import com.fecklefacemassive.www.education.MongoApp.Dao.AnimeBaseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.MongoDbFactory;

@SpringBootApplication
public class MongoAppApplication {

	private static MongoDbFactory mongo;

	private AnimeBaseRepository repository;

	public MongoAppApplication(MongoDbFactory mongo, AnimeBaseRepository repository) {
		this.mongo = mongo;
		this.repository = repository;
	}

	public static void main(String[] args) { SpringApplication.run(MongoAppApplication.class, args); }

}
