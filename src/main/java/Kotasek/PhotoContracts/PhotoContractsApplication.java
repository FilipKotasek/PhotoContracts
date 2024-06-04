package Kotasek.PhotoContracts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PhotoContractsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoContractsApplication.class, args);
	}

}
