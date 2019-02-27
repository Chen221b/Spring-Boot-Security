package com.damon.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Random;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTest {

    @Autowired
    private WebApplicationContext context = null;

    private MockMvc mockMvc = null;

    private Random rand = new Random();

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void whenGetPersonSuccess() throws Exception {
        String name = "damon";
        String ret = mockMvc.perform(get(String.format("/person/%s", name))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is2xxSuccessful())
                .andExpect(jsonPath("$.password").value("0000"))
                .andReturn().getResponse().getContentAsString();

        System.out.println(ret);
    }

    @Test
    public void whenGetPersonFail() throws Exception {
        String name = "damon";
        mockMvc.perform(get(String.format("/person/%s", name))
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().is5xxServerError())
                .andExpect(jsonPath("$.name").value(name));
    }


    @Test
    public void whenInsertPersonSuccess() throws Exception {
        String content = String.format("{\"name\":\"mark%d\", \"password\":\"0000\"}", rand.nextInt(1000));
        System.out.println(content);
        String ret = mockMvc.perform(post("/person")
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(content))
                .andExpect(status().is2xxSuccessful())
                .andReturn().getResponse().getContentAsString();
        System.out.println(ret);
    }
}
