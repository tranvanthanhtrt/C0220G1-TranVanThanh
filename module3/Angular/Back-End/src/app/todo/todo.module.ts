import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TodoComponent } from './todo.component';
import {ReactiveFormsModule} from "@angular/forms";



@NgModule({
  declarations: [TodoComponent],
  exports: [
    TodoComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule
  ]
})
export class TodoModule { }
