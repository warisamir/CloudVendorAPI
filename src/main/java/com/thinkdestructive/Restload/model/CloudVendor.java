package com.thinkdestructive.Restload.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.springframework.stereotype.Service;

@Entity
@Table(name="cloud_vendor_info")
@Data
@NoArgsConstructor
public class CloudVendor {


    @Id
    private String vendorId;
    private String vendorName;
    private String vendorPhonenum;
    private String vendorAddress;

    

}
