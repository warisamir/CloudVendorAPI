package com.thinkdestructive.Restload.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name="cloud_vendor_info")
@Data
@NoArgsConstructor
public class CloudVendor {
    @Id
    @NotBlank(message = "Vendor ID must not be blank")
    private String vendorId;
    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be 2 to 50 characters long")
    private String vendorName;
    @NotBlank(message = "Address is required")
    private String vendorAddress;
    private String vendorPhonenum;
}
