package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class EasyRestTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAllRight() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(post("/easy")
                        .content("""
                                {"name":"X"}""")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("paramA", "23")
                )
                .andReturn().getResponse();
        String contentAsString = response.getContentAsString();
        assertEquals(200, response.getStatus());
        assertEquals("23", contentAsString);
    }

    @Test
    void testWrongBody() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(post("/easy")
                        .content("""
                                {"name":""}""")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("paramA", "23")
                )
                .andReturn().getResponse();
        String contentAsString = response.getContentAsString();
        assertEquals(400, response.getStatus());
        assertEquals("{\"message\":\"BAAAA\"}", contentAsString);
    }

    @Test
    void testNullParam() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(post("/easy")
                        .content("""
                                {"name":"X"}""")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                )
                .andReturn().getResponse();
        String contentAsString = response.getContentAsString();
        assertEquals(400, response.getStatus());
        assertEquals("{\"message\":\"Required request parameter 'paramA' for method parameter type Integer is not present\"}", contentAsString);
    }

    @Test
    void testWrongParam() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(post("/easy")
                        .content("""
                                {"name":"X"}""")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("paramA", "1")
                )
                .andReturn().getResponse();
        String contentAsString = response.getContentAsString();
        assertEquals(400, response.getStatus());
        assertEquals("{\"message\":\"Minimum 2\"}", contentAsString);
    }

    @Test
    void testNoBody() throws Exception {
        MockHttpServletResponse response = mockMvc.perform(post("/easy")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .queryParam("paramA", "2")
                )
                .andReturn().getResponse();
        String contentAsString = response.getContentAsString();
        assertEquals(400, response.getStatus());
        assertEquals("{\"message\":\"Required request body is missing: public java.lang.Integer org.example.EasyRest.easy(org.example.Horse,java.lang.Integer)\"}", contentAsString);
    }

}
