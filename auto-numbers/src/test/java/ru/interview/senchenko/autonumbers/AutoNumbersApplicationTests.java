package ru.interview.senchenko.autonumbers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest
class AutoNumbersApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void testUrlAccess() throws Exception {
        mvc.perform(get("/"))
                .andExpect(status().is4xxClientError());
        mvc.perform(get("/next"))
                .andExpect(status().is2xxSuccessful());
        mvc.perform(get("/random"))
                .andExpect(status().is2xxSuccessful());
    }

}
