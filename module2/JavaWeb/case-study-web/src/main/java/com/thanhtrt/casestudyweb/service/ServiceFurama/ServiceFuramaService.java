package com.thanhtrt.casestudyweb.service.ServiceFurama;

import com.thanhtrt.casestudyweb.model.service.Service;

import java.util.List;

public interface ServiceFuramaService {
    List<Service> findAll();

    void save(Service service);
}
