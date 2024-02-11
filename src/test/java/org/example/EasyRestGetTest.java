package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest
public class EasyRestGetTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void easyRestGetTest() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                get("/easy")
                        //.queryParam("param", "11")
        ).andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
        assertEquals("""
                {"message":"Parameter 'param' must be there","errorCode":-101}""", mvcResult.getResponse().getContentAsString());
    }

}
