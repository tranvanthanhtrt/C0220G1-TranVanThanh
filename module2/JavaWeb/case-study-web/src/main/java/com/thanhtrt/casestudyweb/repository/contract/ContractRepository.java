package com.thanhtrt.casestudyweb.repository.contract;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContractRepository  extends JpaRepository<Contract,Long> {
    Page<Contract> findAllByCustomer_NameContaining(String s, Pageable pageable);
}
