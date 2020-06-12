package com.thanhtrt.casestudyweb.model.service;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name = "services")
public class Service {
    @Id
    @Pattern(regexp = "^SV-\\d{4}$", message = "Service ID miss match!,ex:SV-1234")
    private String id;
    @ManyToOne
    @JoinColumn(name = "serviceTypes_id")
    private ServiceType serviceType;
    @NotEmpty(message = "Service name not empty!")
    private String nameService;
    private float areaUsed;
    private int rentalCost;
    private int maxRenter;
    @ManyToOne
    @JoinColumn(name = "rentTypes_id")
    private TypeOfRent typeOfRent;
    private String standardOfRoom;
    private String describeOtherConvenient;
    private float areaOfPool;
    @Min(1)
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private int level=0;
    private String freeServiceAttack;
    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contractList;

    public Service() {
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public float getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(float areaUsed) {
        this.areaUsed = areaUsed;
    }

    public int getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(int rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaxRenter() {
        return maxRenter;
    }

    public void setMaxRenter(int maxRenter) {
        this.maxRenter = maxRenter;
    }

    public TypeOfRent getTypeOfRent() {
        return typeOfRent;
    }

    public void setTypeOfRent(TypeOfRent typeOfRent) {
        this.typeOfRent = typeOfRent;
    }

    public String getStandardOfRoom() {
        return standardOfRoom;
    }

    public void setStandardOfRoom(String standardOfRoom) {
        this.standardOfRoom = standardOfRoom;
    }

    public String getDescribeOtherConvenient() {
        return describeOtherConvenient;
    }

    public void setDescribeOtherConvenient(String describeOtherConvenient) {
        this.describeOtherConvenient = describeOtherConvenient;
    }

    public float getAreaOfPool() {
        return areaOfPool;
    }

    public void setAreaOfPool(float areaOfPool) {
        this.areaOfPool = areaOfPool;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getFreeServiceAttack() {
        return freeServiceAttack;
    }

    public void setFreeServiceAttack(String freeServiceAttack) {
        this.freeServiceAttack = freeServiceAttack;
    }
}
