package com.thanhtrt.casestudyweb.service.employee;

import com.thanhtrt.casestudyweb.model.employee.Level;
import com.thanhtrt.casestudyweb.repository.employee.LevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LevelServiceImpl implements LevelService{
    @Autowired
    LevelRepository levelRepository;
    @Override
    public List<Level> findAll() {
        return levelRepository.findAll();
    }
}
