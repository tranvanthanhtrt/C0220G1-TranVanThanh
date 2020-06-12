package com.thanhtrt.casestudyweb.repository.detailContract;

import com.thanhtrt.casestudyweb.model.contract.DetailContract;
import com.thanhtrt.casestudyweb.model.contract.DetailContractPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailContractRepository extends JpaRepository<DetailContract, DetailContractPK> {
}
