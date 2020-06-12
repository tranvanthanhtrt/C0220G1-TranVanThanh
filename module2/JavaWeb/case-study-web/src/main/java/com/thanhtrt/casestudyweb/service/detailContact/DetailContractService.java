package com.thanhtrt.casestudyweb.service.detailContact;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import com.thanhtrt.casestudyweb.model.contract.DetailContract;
import com.thanhtrt.casestudyweb.model.contract.DetailContractPK;

import java.util.List;
import java.util.Optional;

public interface DetailContractService {
    List<DetailContract> findAll();
    Optional<DetailContract> finById(DetailContractPK id);
    void save(DetailContract detailContract);
    void remove(DetailContractPK id);}
