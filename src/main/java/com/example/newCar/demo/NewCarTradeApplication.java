package com.example.newCar.demo;

import com.example.newCar.demo.service.DataParseService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.io.IOException;

@SpringBootApplication
@EnableMongoRepositories
public class NewCarTradeApplication implements CommandLineRunner {

	@Autowired
	DataParseService dataParseService;

	public static void main(String[] args) {
		SpringApplication.run(NewCarTradeApplication.class, args);
	}

	public void run(String... args) throws IOException {
		dataParseService.startDataParsingFromHtmlToJavaPojo();
	}
}
