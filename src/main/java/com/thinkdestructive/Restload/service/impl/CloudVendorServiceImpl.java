package com.thinkdestructive.Restload.service.impl;

import com.thinkdestructive.Restload.exception.CloudVendorNotFoundException;
import com.thinkdestructive.Restload.model.CloudVendor;
import com.thinkdestructive.Restload.repository.CloudVendorRepository;
import com.thinkdestructive.Restload.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "Success";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("request cloudVendor doesn't exist.");;
        return cloudVendorRepository.findById(cloudVendorId).get();
    }
    @Override
    public List<CloudVendor> getByVendorName(String vendorName) {
        return cloudVendorRepository.findByVendorName(vendorName);
//        if (vendors.isEmpty()) {
//            throw new CloudVendorNotFoundException("Requested CloudVendor doesn't exist.");
//        }
//        return vendors;
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
