package com.thinkdestructive.Restload.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Table(name="cloud_vendor_info")
@Data

public class CloudVendor {

    private String vendorAddress;
    @Id
    private String vendorId;
    private String vendorName;
    private String vendorPhonenum;

    public String getVendorAddress() {
        return vendorAddress;
    }

    public String getVendorId() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getVendorPhonenum() {
        return vendorPhonenum;
    }

    public void setVendorAddress(String vendorAddress) {
        this.vendorAddress = vendorAddress;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public void setVendorPhonenum(String vendorPhonenum) {
        this.vendorPhonenum = vendorPhonenum;
    }

    public CloudVendor(){

    }

    public CloudVendor(String vendorId, String vendorName, String vendorAddress, String vendorPhonenum) {
        this.vendorId=vendorId;
        this.vendorName=vendorName;
        this.vendorAddress=vendorAddress;
        this.vendorPhonenum=vendorPhonenum;
    }
}
