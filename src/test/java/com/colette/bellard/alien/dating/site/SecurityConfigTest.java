package com.colette.bellard.alien.dating.site;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * SecurityConfigTest is a test class for testing the security configuration of the application.
 * It is annotated with @SpringBootTest, indicating that it should be run with the Spring Boot test support.
 * @AutoConfigureMockMvc is used to set up MockMvc, which offers a powerful way to quickly test MVC controllers without needing to start a full HTTP server.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    /**
     * MockMvc is autowired to simulate HTTP requests in the tests.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * This test method checks if an unauthorized request to the "/test" endpoint returns a 401 Unauthorized status.
     * @throws Exception if any exception occurs during the request execution
     */
    @Test
    public void accessProtected() throws Exception {
        this.mockMvc.perform(get("/test"))
            .andExpect(status().isUnauthorized());
    }
}