package com.thanhtrt.casestudyweb.service.contract;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import com.thanhtrt.casestudyweb.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ContractService {
    Page<Contract> findAll(Pageable pageable);
    Optional<Contract> finById(Long id);
    void save(Contract contract);
    void remove(Long id);
    Page<Contract> findAllByNameCustomer(String s,Pageable pageable);
}
