package com.thanhtrt.casestudyweb.service.employee;

import com.thanhtrt.casestudyweb.model.employee.Position;
import com.thanhtrt.casestudyweb.repository.employee.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PositionServiceImpl implements PositionService {
    @Autowired
    PositionRepository positionRepository;
    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }
}
