package ftn.udd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("ftn.udd.model")
public class UddApplication {

	public static void main(String[] args) {
		SpringApplication.run(UddApplication.class, args);
	}

}
