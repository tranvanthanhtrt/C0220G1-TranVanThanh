import {Component, OnDestroy, OnInit} from '@angular/core';
import {Route, Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit, OnDestroy{
  title = 'Angular-service-router';
constructor(private router: Router) {
}
  goTimeLines() {
this.router.navigate(['timelines']);
  }

  ngOnDestroy(): void {
  }

  ngOnInit(): void {
  }

  goYoutube() {
    this.router.navigate(['youtube']);

  }

  goDictionary() {
    this.router.navigate(['dictionary'])
  }
}
