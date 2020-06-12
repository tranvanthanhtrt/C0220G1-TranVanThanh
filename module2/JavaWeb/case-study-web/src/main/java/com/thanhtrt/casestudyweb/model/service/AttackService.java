package com.thanhtrt.casestudyweb.model.service;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import com.thanhtrt.casestudyweb.model.contract.DetailContract;
import com.thanhtrt.casestudyweb.model.customer.CustomerType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "attackServices")
public class AttackService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long rent;
    @OneToMany(targetEntity = DetailContract.class)
    private List<DetailContract> detailContractList;
       public AttackService() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public List<DetailContract> getDetailContractList() {
        return detailContractList;
    }

    public void setDetailContractList(List<DetailContract> detailContractList) {
        this.detailContractList = detailContractList;
    }
}
