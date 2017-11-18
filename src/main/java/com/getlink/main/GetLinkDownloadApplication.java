package com.getlink.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.getlink"})
public class GetLinkDownloadApplication extends SpringBootServletInitializer {
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringApplicationBuilder.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(GetLinkDownloadApplication.class, args);
	}
}
