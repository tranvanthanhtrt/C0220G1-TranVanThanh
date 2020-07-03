import {Component, Inject, OnInit} from '@angular/core';
import {Customer} from "../../customer";
import {CustomerService} from "../../customer.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-customer-detail',
  templateUrl: './customer-detail.component.html',
  styleUrls: ['./customer-detail.component.scss']
})
export class CustomerDetailComponent implements OnInit {
  customer: Customer;

  constructor( private customerService: CustomerService,
               private router: Router,
               private activatedRoute: ActivatedRoute,
     ) {

  }
  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param: ParamMap) => {
      const id = Number(param.get('id'));
      this.customerService.findById(id).subscribe(
        next => {
          this.customer = next;
        },
        error => {
          console.log(error);
          this.customer = null;
        }
      )
    })
  }

}
