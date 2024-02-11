package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest
public class EasyRestPostTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void easyRestGetTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                post("/easy")
                .content("""
                       {"name":"", "id":-2}""")
                        .contentType(MediaType.APPLICATION_JSON)
        ).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
        assertEquals("X", mvcResult.getResponse().getContentAsString());
    }

}
