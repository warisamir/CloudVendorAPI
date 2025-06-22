package com.thinkdestructive.Restload.service;

import com.thinkdestructive.Restload.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {
    public String createCloudVendor(CloudVendor cloudVendor);
    public String updateCloudVendor(CloudVendor cloudVendor);
    public String deleteCloudVendor(String cloudvendorId );
    public CloudVendor getCloudVendor(String cloudvendorId );

    List<CloudVendor> getByVendorName(String vendorName);

    public List<CloudVendor> getAllCloudVendor();
}
