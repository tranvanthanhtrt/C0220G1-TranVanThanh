package com.thanhtrt.casestudyweb.model.contract;

import com.thanhtrt.casestudyweb.model.service.AttackService;

import javax.persistence.Embeddable;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
@Embeddable
public class DetailContractPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "contracts_id")
    private Contract contract;
    @ManyToOne
    @JoinColumn(name = "attackServices_id")
    private AttackService attackService;

    public DetailContractPK() {}

       // equals, hashCode


    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttackService getAttackService() {
        return attackService;
    }

    public void setAttackService(AttackService attackService) {
        this.attackService = attackService;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
