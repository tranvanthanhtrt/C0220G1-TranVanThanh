package com.thanhtrt.casestudyweb.repository.customer;

import com.thanhtrt.casestudyweb.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface CustomerTypeRepository extends JpaRepository<CustomerType,Long> {

}
