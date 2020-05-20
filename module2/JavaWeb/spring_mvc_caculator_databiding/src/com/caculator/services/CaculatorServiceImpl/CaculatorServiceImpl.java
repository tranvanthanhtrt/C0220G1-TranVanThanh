package com.caculator.services.CaculatorServiceImpl;

import com.caculator.services.CaculatorService;
import org.springframework.stereotype.Service;

@Service
public class CaculatorServiceImpl implements CaculatorService {
    @Override
    public double add(double num1, double num2) {
        return num1+num2;
    }

    @Override
    public double sub(double num1, double num2) {
        return num1-num2;
    }

    @Override
    public double mul(double num1, double num2) {
        return num1*num2;
    }

    @Override
    public double div(double num1, double num2) {
      try{  return num1/num2;}
      catch (Exception e){
          e.getMessage();
      }
        return 0;
    }
}
