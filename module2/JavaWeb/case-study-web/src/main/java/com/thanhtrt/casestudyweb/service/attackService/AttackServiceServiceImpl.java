package com.thanhtrt.casestudyweb.service.attackService;

import com.thanhtrt.casestudyweb.model.service.AttackService;
import com.thanhtrt.casestudyweb.repository.service.AttackServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AttackServiceServiceImpl implements AttackServiceService{
    @Autowired
    AttackServiceRepository attackServiceRepository;
    @Override
    public List<AttackService> findAll() {
        return attackServiceRepository.findAll();
    }

    @Override
    public Optional<AttackService> finById(Long id) {
        return attackServiceRepository.findById(id);
    }

    @Override
    public void save(AttackService attackService) {
        attackServiceRepository.save(attackService);

    }

    @Override
    public void remove(Long id) {
        attackServiceRepository.deleteById(id);

    }
}
