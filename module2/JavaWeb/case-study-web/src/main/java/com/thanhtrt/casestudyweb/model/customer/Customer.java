package com.thanhtrt.casestudyweb.model.customer;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @Pattern(regexp = "^KH-\\d{4}$", message = "Customer ID same with KH-1234")
    private String id;
    @NotEmpty(message = "Customer name not empty!")
    private String name;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "Birthday not null!")
    private Date birthday;
    @NotNull(message = "Gender not null!")
    private String gender;
    private String cmnd;
    @Pattern(regexp = "(090|091|\\(84\\)\\+90|\\(84\\)\\+91)([0-9]{7})$", message = "miss match phone number")
    private String phoneNumber;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "customerTypes_id")
    private CustomerType customerType;
    @OneToMany(targetEntity = Contract.class)
    private List<Contract> contractList;

    public Customer() {
    }

    public List<Contract> getContractList() {
        return contractList;
    }

    public void setContractList(List<Contract> contractList) {
        this.contractList = contractList;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }
}

