import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {CustomerComponent} from "./customer/customer.component";
import {CustomerCreateComponent} from "./customer/customer-create/customer-create.component";
import {CustomerEditComponent} from "./customer/customer-edit/customer-edit.component";
import {CustomerDetailComponent} from "./customer/customer-detail/customer-detail.component";


const routes: Routes = [
  {
    path: 'customers',
    component: CustomerComponent
  },
  {
    path: 'customer-create',
    component: CustomerCreateComponent
  },
  {
    path: 'customers/:id/edit',
    component: CustomerEditComponent
  },
  {
    path: 'customers/:id/detail',
    component: CustomerDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
