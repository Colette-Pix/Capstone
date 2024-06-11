package com.colette.bellard.alien.dating.site;

import com.colette.bellard.alien.dating.site.entity.user.profile.UserProfileRepository;
import com.colette.bellard.alien.dating.site.entity.user.profile.UserProfileService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    public UserProfileService userProfileService(UserProfileRepository userProfileRepository) {
        return new UserProfileService(userProfileRepository);
    }
}