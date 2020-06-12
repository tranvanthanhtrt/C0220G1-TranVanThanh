package com.thanhtrt.casestudyweb.model.contract;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import com.thanhtrt.casestudyweb.model.service.AttackService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "detailContract")
public class DetailContract implements Serializable {
@EmbeddedId
private DetailContractPK id;
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "contracts_id")
//    private Contract contract;
//    @Id
//    @ManyToOne
//    @JoinColumn(name = "attackServices_id")
//    private AttackService attackService;
    private Integer count;

    public DetailContract() {
    }

    public DetailContractPK getId() {
        return id;
    }

    public void setId(DetailContractPK id) {
        this.id = id;
    }

//    public Contract getContract() {
//        return contract;
//    }
//
//    public void setContract(Contract contract) {
//        this.contract = contract;
//    }
//
//    public AttackService getAttackService() {
//        return attackService;
//    }
//
//    public void setAttackService(AttackService attackService) {
//        this.attackService = attackService;
//    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
