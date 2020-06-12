package com.thanhtrt.casestudyweb.service.customer;

import com.thanhtrt.casestudyweb.model.customer.CustomerType;
import com.thanhtrt.casestudyweb.repository.customer.CustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {
 @Autowired
 CustomerTypeRepository customerTypeRepository;
    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
