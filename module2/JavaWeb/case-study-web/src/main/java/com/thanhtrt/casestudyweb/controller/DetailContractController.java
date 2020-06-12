package com.thanhtrt.casestudyweb.controller;

import com.thanhtrt.casestudyweb.model.contract.Contract;
import com.thanhtrt.casestudyweb.model.contract.DetailContract;
import com.thanhtrt.casestudyweb.model.employee.Employee;
import com.thanhtrt.casestudyweb.model.service.AttackService;
import com.thanhtrt.casestudyweb.service.attackService.AttackServiceService;
import com.thanhtrt.casestudyweb.service.contract.ContractService;
import com.thanhtrt.casestudyweb.service.detailContact.DetailContractService;
import com.thanhtrt.casestudyweb.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class DetailContractController {

    @Autowired
    ContractService contractService;

    @ModelAttribute("contractList")
    public Page<Contract> contractList(Pageable pageable) {
        return contractService.findAll(pageable);
    }

    @Autowired
    AttackServiceService attackServiceService;

    @ModelAttribute("attackServiceList")
    public List<AttackService> attackServiceList() {
        return attackServiceService.findAll();
    }

    @Autowired
    DetailContractService detailContractService;

    @GetMapping("/create-detail-contract")
    public ModelAndView showCreateDetailContractForm() {
        ModelAndView modelAndView = new ModelAndView("/detailContract/create");
        modelAndView.addObject("detailContract", new DetailContract());
        return modelAndView;
    }

    @PostMapping("/create-detail-contract")
    public ModelAndView saveDetailContract(@ModelAttribute("detailContract") DetailContract detailContract) {
        ModelAndView modelAndView = new ModelAndView(("/detailContract/create"));

        if (detailContractService.finById(detailContract.getId()).isPresent()) {
            calTotal(detailContract);
            Optional<DetailContract> detailContractSur = detailContractService.finById(detailContract.getId());
            Integer newCount = detailContractSur.get().getCount() + detailContract.getCount();
            detailContractSur.get().setCount(newCount);
            detailContractService.save(detailContractSur.get());

            modelAndView.addObject("detailContract", new DetailContract());
            modelAndView.addObject("message", "Attack service has added");
            return modelAndView;

        }
        calTotal(detailContract);


        detailContractService.save(detailContract);
        modelAndView.addObject("detailContract", new DetailContract());
        modelAndView.addObject("message", "New detail contract created successfully");
        return modelAndView;
    }

    public void calTotal(DetailContract detailContract) {
        /* tính tổng tiền rồi cập nhật lại contract*/
        Long idDetailContract = detailContract.getId().getContract().getId();
        AttackService attackService = detailContract.getId().getAttackService();
        Long attackServiceCost = attackService.getRent() * detailContract.getCount();
        Optional<Contract> contract = contractService.finById(idDetailContract);
        Long newTotal = attackServiceCost + contract.get().getTotal();
        contract.get().setTotal(newTotal);
        contractService.save(contract.get());
    }
}
