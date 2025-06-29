package com.thinkdestructive.Restload.controller;

import com.thinkdestructive.Restload.model.CloudVendor;
import com.thinkdestructive.Restload.response.ResponseHandler;
import com.thinkdestructive.Restload.service.CloudVendorService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudvendor")
public class CloudVendorController {
    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }

    @GetMapping("/{vendorId}")
    public ResponseEntity<Object> getVendorDetails(@Valid @PathVariable("vendorId") String vendorId){
        return  ResponseHandler.responseBuilder("Requested Vendor Details given here", HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));
    }

    @GetMapping("/")
    public List<CloudVendor> getAllVendorDetails(){
        return cloudVendorService.getAllCloudVendor();
    }
    @PostMapping("/createCloudVendor")
    public String createCloudVendorDetails(@Valid @RequestBody CloudVendor cloudvendor){
        cloudVendorService.createCloudVendor(cloudvendor);
        return "cloud vendor created succesfully";
    }

    @PutMapping("/updateDetails")
    public String updateCloudVendorDetails(@Valid @RequestBody CloudVendor cloudvendor){
        cloudVendorService.updateCloudVendor(cloudvendor);
        return "vendor details has been updated";
    }
    @DeleteMapping("{vendorId}")
    public String deleteCloudVendorDetails(@Valid @PathVariable("vendorId") String vendorId){
        cloudVendorService.deleteCloudVendor(vendorId);
        return "cloud vendor Delete successfully";
    }
    @DeleteMapping("/deleteAll")
    public String deleteCloudVendorDetails(){
        cloudVendorService.deleteAllCloudVendor();
        return "All vendor list is cleared Successfully";
    }
}
