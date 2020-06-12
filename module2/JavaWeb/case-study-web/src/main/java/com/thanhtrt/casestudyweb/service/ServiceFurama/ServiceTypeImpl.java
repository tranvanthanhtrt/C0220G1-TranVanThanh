package com.thanhtrt.casestudyweb.service.ServiceFurama;

import com.thanhtrt.casestudyweb.model.service.ServiceType;
import com.thanhtrt.casestudyweb.repository.service.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeImpl implements ServiceTypeService {
    @Autowired
    ServiceTypeRepository serviceTypeRepository;
    @Override
    public List<ServiceType> findAll() {
        return serviceTypeRepository.findAll();
    }
}
