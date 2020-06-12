package com.thanhtrt.casestudyweb.service.attackService;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import com.thanhtrt.casestudyweb.model.service.AttackService;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.Optional;

public interface AttackServiceService {
    List<AttackService> findAll();
    Optional<AttackService> finById(Long id);
    void save(AttackService attackService);
    void remove(Long id);
}
