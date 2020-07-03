import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AppComponent} from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import {CustomerModule} from "./customer/customer.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {CustomerDetailComponent} from "./customer/customer-detail/customer-detail.component";
import {MatFormFieldModule} from "@angular/material/form-field";


@NgModule({
  declarations: [
    AppComponent,
  ],
  entryComponents: [
    CustomerDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CustomerModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
