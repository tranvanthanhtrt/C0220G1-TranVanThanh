import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FormGroup} from "@angular/forms";
import {Customer} from "./customer";
import {LoaiKhach} from "./loaiKhach";
@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  API_URL = 'http://localhost:3000/customerList';
  LoaiKhach_URL = 'http://localhost:3000/loaiKhachList';

  constructor( private httpClient: HttpClient) {

  }
  findAll(): Observable<Customer[]>{
    return this.httpClient.get<Customer[]>(this.API_URL)
  }
  findById(id: number): Observable<Customer>{
    return this.httpClient.get<Customer>(this.API_URL+ '/'+id);
  }
  creatCustomer(customer: FormGroup): Observable<Customer> {
    return this.httpClient.post<Customer>(this.API_URL, customer);
  }
  updateCustomer(customer: Customer): Observable<Customer>{
    return this.httpClient.patch<Customer>(`${this.API_URL}/${customer.id}`, customer)
  }
  deleteCustomer(id: Number): Observable<any> {
    return  this.httpClient.delete(this.API_URL+'/'+id);
  }
  findAllLoaiKhach(): Observable<LoaiKhach[]>{
    return this.httpClient.get<LoaiKhach[]>(this.LoaiKhach_URL)
  }
}
