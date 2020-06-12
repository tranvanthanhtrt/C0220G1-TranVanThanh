package com.thanhtrt.casestudyweb.repository.service;

import com.thanhtrt.casestudyweb.model.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository  extends JpaRepository<Service,String> {
}
