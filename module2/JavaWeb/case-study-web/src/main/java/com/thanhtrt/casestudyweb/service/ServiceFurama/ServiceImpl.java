package com.thanhtrt.casestudyweb.service.ServiceFurama;

import com.thanhtrt.casestudyweb.repository.service.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceFuramaService {
    @Autowired
    ServiceRepository serviceRepository;

    @Override
    public List<com.thanhtrt.casestudyweb.model.service.Service> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public void save(com.thanhtrt.casestudyweb.model.service.Service service) {
        serviceRepository.save(service);

    }
}
