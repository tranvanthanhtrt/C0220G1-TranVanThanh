package com.thanhtrt.casestudyweb.model.contract;

import com.thanhtrt.casestudyweb.model.customer.Customer;
import com.thanhtrt.casestudyweb.model.employee.Employee;
import com.thanhtrt.casestudyweb.model.service.Service;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contracts")
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "customers_id")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employees_id")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "services_id")
    private Service service;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date startDay=new Date(System.currentTimeMillis());
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    private Date endDay=new Date(System.currentTimeMillis());
    private Long deposit;
    @OneToMany(targetEntity = DetailContract.class)
    private List<DetailContract> detailContractList;
    private Long total;

    public Contract() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public Long getDeposit() {
        return deposit;
    }

    public void setDeposit(Long deposit) {
        this.deposit = deposit;
    }

    public List<DetailContract> getDetailContractList() {
        return detailContractList;
    }

    public void setDetailContractList(List<DetailContract> detailContractList) {
        this.detailContractList = detailContractList;
    }
}
