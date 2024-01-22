package january.sixteenth.service.impl;

import january.sixteenth.model.CloudVendor;
import january.sixteenth.repository.CloudVendorRepository;
import january.sixteenth.service.CloudVendorService;
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
        return "Create successfully";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudVendor) {
        cloudVendorRepository.save(cloudVendor);
        return "Update successfully";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        if (cloudVendorRepository.findById(cloudVendorId).isPresent()) {
            cloudVendorRepository.deleteById(cloudVendorId);
            return "Delete successfully";
        } else {
            return String.format("Cloud Vendor with id = %s does not exist", cloudVendorId);
        }
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if (cloudVendorRepository.findById(cloudVendorId).isPresent()){
            return cloudVendorRepository.findById(cloudVendorId).get();
        } else {
            return null;
        }
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {
        return cloudVendorRepository.findAll();
    }
}
