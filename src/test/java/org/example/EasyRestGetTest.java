package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
public class EasyRestGetTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void easyRestGetTestOk() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/easy")
                        .queryParam("param", "3")
        ).andReturn();
        assertEquals(200, mvcResult.getResponse().getStatus());
        assertEquals("3", mvcResult.getResponse().getContentAsString());
    }

    @Test
    void easyRestGetTestNoParam() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/easy")
        ).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
        assertEquals("{\"message\":\"Required request parameter 'param' for method parameter type Integer is not present\",\"errorCode\":-100}", mvcResult.getResponse().getContentAsString());
    }

}