package com;

import com.education.properties.OpenApiProperties;
import com.education.properties.ServerProperties;
import com.education.repository.AddressRepository;
import com.education.repository.AuthUserRepository;
import com.education.repository.EducationRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({
        OpenApiProperties.class,
        ServerProperties.class
})
@OpenAPIDefinition
@RequiredArgsConstructor
@Log4j2
public class EducationApplication {

    private final AuthUserRepository authUserRepository;
    private final AddressRepository addressRepository;
    private final EducationRepository educationRepository;

    private final  PasswordEncoder passwordEncoder;

    public static void main(String[] args) {

        SpringApplication.run(EducationApplication.class, args);
    }

    @SuppressWarnings("rawtypes")
    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.SECONDS)
    void testRequest() {


    }

    @Bean("messageSource")
    public ResourceBundleMessageSource messageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("i18n");
        source.setDefaultLocale(Locale.forLanguageTag("uz"));
        source.setDefaultEncoding("UTF-8");
        source.setUseCodeAsDefaultMessage(true);
        return source;
    }
}
