package com.thinkdestructive.Restload.repository;

import com.thinkdestructive.Restload.model.CloudVendor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;

    private CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
        // Setup a CloudVendor record before each test
        cloudVendor = new CloudVendor("1", "Amazon", "USA", "XXXX");
        cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
        // Cleanup database after each test
        cloudVendorRepository.deleteAll();
    }

    @Test
    @DisplayName("Should return CloudVendor when vendor name exists")
    void testFindByVendorName_Found() {
        // Act
        List<CloudVendor> cloudVendorList = cloudVendorRepository.findByVendorName("Amazon");

        // Assert
       // assertThat(cloudVendorList.isEmpty()).isTrue();
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }

    @Test
    @DisplayName("Should return empty list when vendor name does not exist")
    void testFindByVendorName_NotFound() {
        // Act
        List<CloudVendor> result = cloudVendorRepository.findByVendorName("GCP");

        // Assert
        assertThat(result).isEmpty();
    }
}
