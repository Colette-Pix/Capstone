package com.colette.bellard.alien.dating.site;

import com.colette.bellard.alien.dating.site.repositories.UserProfileRepository;
import com.colette.bellard.alien.dating.site.services.UserProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ServiceConfiguration is a configuration class for the UserProfileService.
 * It is annotated with @Configuration, indicating that it is a Spring configuration class.
 */
@Configuration
public class ServiceConfiguration {

    /**
     * This method provides a UserProfileService bean.
     * It is annotated with @Bean, indicating that the returned UserProfileService should be registered as a bean in the Spring application context.
     * The UserProfileService is initialized with a UserProfileRepository, which is used for database operations.
     *
     * @param userProfileRepository the UserProfileRepository to be used by the UserProfileService
     * @return a UserProfileService initialized with the provided UserProfileRepository
     */
    @Bean
    public UserProfileService userProfileService(UserProfileRepository userProfileRepository) {
        return new UserProfileService(userProfileRepository);
    }
}