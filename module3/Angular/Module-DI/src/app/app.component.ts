import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Module-DI';
  constructor(private router: Router) {
  }
  goImageGallery() {
    this.router.navigate(['image-gallery'])

  }
}
