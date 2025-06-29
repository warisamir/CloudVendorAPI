package com.thinkdestructive.Restload.service.impl;
import com.thinkdestructive.Restload.exception.CloudVendorNotFoundException;
import com.thinkdestructive.Restload.exception.NoCloudVendorExistException;
import com.thinkdestructive.Restload.model.CloudVendor;
import com.thinkdestructive.Restload.repository.CloudVendorRepository;
import com.thinkdestructive.Restload.service.CloudVendorService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.NotAcceptableStatusException;
import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {
    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository) {
        this.cloudVendorRepository = cloudVendorRepository;
    }
    @Override
    public String createCloudVendor(CloudVendor cloudVendor) {
        if(cloudVendorRepository.findById(cloudVendor.getVendorId()).isPresent()){
            throw new NotAcceptableStatusException("you are not allowed to create vendor with same vendor id");
        }
        cloudVendorRepository.save(cloudVendor);
        return "Success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        if(cloudVendorRepository.findById(cloudVendor.getVendorId()).isPresent()) {
            cloudVendorRepository.save(cloudVendor);
            return "Success";
        }
        throw new CloudVendorNotFoundException("No such cloudVendor exist with given vendor Id = "+cloudVendor.getVendorId());
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isPresent()){
            cloudVendorRepository.deleteById(cloudVendorId);
            return "Success";
        }
        throw new CloudVendorNotFoundException("No such cloudVendor exist with vendor Id = "+cloudVendorId);
}

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("request cloudVendor doesn't exist.");;
        return cloudVendorRepository.findById(cloudVendorId).get();
    }
    @Override
    public List<CloudVendor> getByVendorName(String vendorName) {
        if (cloudVendorRepository.findByVendorName(vendorName).isEmpty())
            throw new CloudVendorNotFoundException("CloudVendor Name doesn't Match with any existing vendorName.");
        return cloudVendorRepository.findByVendorName(vendorName);
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        System.out.println(cloudVendorRepository.findAll());
        if(cloudVendorRepository.findAll().isEmpty()){
            throw new NoCloudVendorExistException("No Vendor Exist in the DB.");
        }
        return cloudVendorRepository.findAll();
    }

    public String deleteAllCloudVendor(){
        cloudVendorRepository.deleteAllInBatch();
        return "Success";
    }
}
