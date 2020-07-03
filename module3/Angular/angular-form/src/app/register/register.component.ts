import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  registerForm: FormGroup;

  constructor() {
  }
onSubmit(): void {
    if (this.registerForm.valid) {
    console.log(this.registerForm.value); }
    else { console.log('lỗi rồi'); }
}
  ngOnInit(): void {
    this.registerForm = new FormGroup({
      email: new FormControl('', [ Validators.email]),
      pwGroup: new FormGroup({
        password: new FormControl('', [Validators.pattern('[a-z A-Z 0-9]{6}')]),
        confirmPassword: new FormControl('')
      }, this.confirmPassword),
      country: new FormControl('', [Validators.required]),
      age: new FormControl(''),
      gender: new FormControl('', [Validators.required]),
      phone: new FormControl('', [Validators.pattern('^\\+84\\d{9,10}$')])
    });
  }
 confirmPassword(c: AbstractControl) {
    const v = c.value;
    return (v.password === v.confirmPassword) ?
      null : {
        passwordnotmatch: true
      };
  }

}
