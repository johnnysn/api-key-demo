package org.uriel.apikeydemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.StringContains.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${application.security.api-key}")
    private String apiKey;

    @Test
    void shouldGetPublicGreetings() throws Exception {
        this.mockMvc.perform(get("/public/greetings"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Greetings")));
    }

    @Test
    void shouldGetProtectedGreetings() throws Exception {
        this.mockMvc.perform(get("/protected/greetings").header("ApiKey", apiKey))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Greetings")));
    }

    @Test
    void shouldReturnError_IfWrongApiKeyIsProvided_WhenAccessingProtectedGreetings() throws Exception {
        this.mockMvc.perform(get("/protected/greetings").header("ApiKey", "mywrongkey"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void shouldReturnError_IfNoApiKeyIsProvided_WhenAccessingProtectedGreetings() throws Exception {
        this.mockMvc.perform(get("/protected/greetings"))
                .andExpect(status().isUnauthorized());
    }
}