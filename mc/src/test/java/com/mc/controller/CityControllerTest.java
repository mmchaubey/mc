package com.mc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.mc.service.CityService;
import static org.mockito.BDDMockito.given;


@RunWith(SpringRunner.class)
@WebMvcTest(CityController.class)
public class CityControllerTest {
	
	@Autowired
    private MockMvc mockMvc;
	@MockBean
    private CityService cityService;
    
    @Test
    public void getOriginDestinationSuccess() throws Exception {
        // given
        String origin = "Newark";
        String destination = "Boston";
        String endpoint = "/connected?origin="+origin+"&destination="+destination;

        given(cityService.isconnected(origin, destination)).willReturn("yes");

        // when + then
        this.mockMvc.perform(get(endpoint))
                .andExpect(status().isOk())
                .andExpect(content().string("yes"));
    }
    
    @Test
    public void getOriginDestinationFailure() throws Exception {
        // given
        String origin = "Boston";
        String destination = "Newark";
        String endpoint = "/connected?origin="+origin+"&destination="+destination;

        given(cityService.isconnected(origin, destination)).willReturn("no");

        // when + then
        this.mockMvc.perform(get(endpoint))
                .andExpect(status().isOk())
                .andExpect(content().string("no"));
    }
	
}
