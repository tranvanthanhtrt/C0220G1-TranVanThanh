package com.thanhtrt.casestudyweb.service.RentType;

import com.thanhtrt.casestudyweb.model.service.TypeOfRent;
import com.thanhtrt.casestudyweb.repository.service.RentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RentTypeServiceImpl implements RentypeService {
    @Autowired
    RentTypeRepository rentTypeRepository;
    @Override
    public List<TypeOfRent> findAll() {
        return rentTypeRepository.findAll() ;
    }
}
