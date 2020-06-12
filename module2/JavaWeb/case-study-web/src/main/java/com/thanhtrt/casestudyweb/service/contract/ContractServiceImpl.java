package com.thanhtrt.casestudyweb.service.contract;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import com.thanhtrt.casestudyweb.repository.contract.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractRepository contractRepository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return contractRepository.findAll(pageable);
    }

    @Override
    public Optional<Contract> finById(Long id) {
        return contractRepository.findById(id);
    }

    @Override
    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    @Override
    public void remove(Long id) {
        contractRepository.deleteById(id);
    }

    @Override
    public Page<Contract> findAllByNameCustomer(String s, Pageable pageable) {
        return contractRepository.findAllByCustomer_NameContaining( s, pageable);
    }
}
