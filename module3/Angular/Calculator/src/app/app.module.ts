import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CalculatorComponent } from './calculator/calculator.component';
import {FormsModule} from '@angular/forms';
import { PickColorComponent } from './pick-color/pick-color.component';
import { HeroesComponent } from './heroes/heroes.component';
import { HeroDetailComponent } from './hero-detail/hero-detail.component';
import { SearchProjectComponent } from './search-project/search-project.component';

@NgModule({
  declarations: [
    AppComponent,
    CalculatorComponent,
    PickColorComponent,
    HeroesComponent,
    HeroDetailComponent,
    SearchProjectComponent
  ],
    imports: [
        BrowserModule,
        FormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
