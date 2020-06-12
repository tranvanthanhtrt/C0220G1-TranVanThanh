package com.thanhtrt.casestudyweb.service.detailContact;

import com.thanhtrt.casestudyweb.model.contract.DetailContract;
import com.thanhtrt.casestudyweb.model.contract.DetailContractPK;
import com.thanhtrt.casestudyweb.repository.detailContract.DetailContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetailContractServiceImpl implements DetailContractService{
    @Autowired
    DetailContractRepository  detailContractRepository;
    @Override
    public List<DetailContract> findAll() {
        return detailContractRepository.findAll();
    }

    @Override
    public Optional<DetailContract> finById(DetailContractPK id) {
        return detailContractRepository.findById(id);
    }

    @Override
    public void save(DetailContract detailContract) {
        detailContractRepository.save(detailContract);
    }

    @Override
    public void remove(DetailContractPK id) {
detailContractRepository.deleteById(id);
    }
}
