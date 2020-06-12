package com.thanhtrt.casestudyweb.repository.service;

import com.thanhtrt.casestudyweb.model.service.TypeOfRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RentTypeRepository extends JpaRepository<TypeOfRent,Long> {
}
