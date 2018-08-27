package com.fecklefacemassive.www.education.MongoApp;

import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.MongoDbFactory;

@SpringBootApplication
public class MongoAppApplication {

	private static MongoDbFactory mongo;

	@Autowired
	public MongoAppApplication(MongoDbFactory mongo) {
		this.mongo = mongo;
	}

	public static void main(String[] args) {

	    SpringApplication.run(MongoAppApplication.class, args);
	    runTest();
	}


    public static void runTest() {
		MongoDatabase db = mongo.getDb();

		String x = db.getName();

		db.createCollection("NewCollection");


    }

}
