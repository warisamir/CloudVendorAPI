package com.thinkdestructive.Restload.repository;

import com.thinkdestructive.Restload.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
    List<CloudVendor> findByVendorName(String vendorName);

    @Override
    void deleteAllInBatch();

    @Override
    Optional<CloudVendor> findById(String s);
}
