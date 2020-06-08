package dev.anki.app.fileupload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "dev.anki")
public class FileItAwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileItAwayApplication.class, args);
	}

}
