package com.example.k8s.springbootpostgresk8s;

import com.example.k8s.springbootpostgresk8s.Model.AuditorAwareImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class SpringbootPostgresK8sApplication implements CommandLineRunner {

	@Autowired
	private Environment env;

	@Bean
	public AuditorAware<String> auditorAware(){

		return new AuditorAwareImpl();
	}

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(SpringbootPostgresK8sApplication.class);
		app.run();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("spring.jpa.database: " + env.getProperty("spring.jpa.database"));
		System.out.println("spring2.jpa2.database2: " + env.getProperty("spring2.jpa2.database2"));
		System.out.println("spring-env: " + env.getProperty("spring-env"));
		System.out.println("spring-env: " + env.getProperty("java.home"));
		System.out.println("fac.alex2: " + env.getProperty("fac.alex2"));
	}

}
