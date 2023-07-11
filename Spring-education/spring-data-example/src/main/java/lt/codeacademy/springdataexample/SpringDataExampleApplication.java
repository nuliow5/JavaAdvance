package lt.codeacademy.springdataexample;

import lt.codeacademy.springdataexample.services.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataExampleApplication.class, args);
		System.out.println("start");



	}

}
