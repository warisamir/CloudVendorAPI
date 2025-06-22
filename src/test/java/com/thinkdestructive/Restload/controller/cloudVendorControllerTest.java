package com.thinkdestructive.Restload.controller;

import com.thinkdestructive.Restload.Utility.RequestJson;
import com.thinkdestructive.Restload.model.CloudVendor;
import com.thinkdestructive.Restload.service.CloudVendorService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CloudVendorController.class)

class cloudVendorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CloudVendorService cloudVendorService;
    CloudVendor cloudVendor1;
    CloudVendor cloudVendor2;
    List<CloudVendor> cloudVendorList=new ArrayList<>();


    @BeforeEach
    void setUp() {
        cloudVendor1= new CloudVendor("1","Amazon","USA","XXXX");
        cloudVendor2= new CloudVendor("2","GCP","America","YYYY");
        cloudVendorList.add(cloudVendor1);
        cloudVendorList.add(cloudVendor2);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testGetVendorDetails() throws Exception {
       when(cloudVendorService.getCloudVendor("1"))
               .thenReturn(cloudVendor1);
        this.mockMvc.perform(get("/cloudvendor/1"))
               .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testGetAllVendorDetails() throws Exception {
        when(cloudVendorService.getAllCloudVendor())
                .thenReturn(cloudVendorList);
        this.mockMvc.perform(get("/cloudvendor"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testCreateCloudVendorDetails() throws Exception {
        when(cloudVendorService.createCloudVendor(cloudVendor1)).thenReturn("Success");

        this.mockMvc.perform(post("/cloudvendor/createCloudVendor")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(RequestJson.toJson(cloudVendor1)))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void updateCloudVendorDetails() throws Exception{
        when(cloudVendorService.createCloudVendor(cloudVendor1)).thenReturn("Success");
        this.mockMvc.perform(put("/cloudvendor/updateDetails").contentType(
                MediaType.APPLICATION_JSON).content(RequestJson.toJson(cloudVendor1)))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    void testDeleteCloudVendorDetails() throws Exception{
        when(cloudVendorService.deleteCloudVendor("1")).thenReturn("Sucesss");
        this.mockMvc.perform(delete("/cloudvendor/1"))
                .andDo(print()).andExpect(status().isOk());
    }
}