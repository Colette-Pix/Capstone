package com.colette.bellard.alien.dating.site;

//import com.colette.bellard.alien.dating.site.entity.human.Human;
//import com.colette.bellard.alien.dating.site.entity.human.HumanService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class UserDetailsServiceTest {
/*
    @Autowired
    private UserDetailsService userDetailsService;

    @MockBean
    private HumanService humanService;

    @Test
    public void loadUserByUsername() {
        when(humanService.findByUsername("s")).thenReturn(new Human("s", "s"));

        UserDetails userDetails = userDetailsService.loadUserByUsername("s");

        assertNotNull(userDetails);
        assertEquals("s", userDetails.getUsername());
    }*/
}