import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {AppComponent} from "./app.component";
import {HttpClientModule} from "@angular/common/http";
import {AppRoutingModule} from "./app-routing.module";
import {SinhvienModule} from "./sinhvien/sinhvien.module";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatFormFieldModule} from "@angular/material/form-field";


@NgModule({
  declarations: [
    AppComponent,
  ],
  entryComponents: [
      ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    SinhvienModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
  ],
  providers: [
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
