import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {ProgressBarComponent} from './progress-bar/progress-bar.component';
import {NameCardComponent} from './name-card/name-card.component';
import {RatingBarComponent} from './rating-bar/rating-bar.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';

@NgModule({
  declarations: [
    AppComponent,
    ProgressBarComponent,
    NameCardComponent,
    RatingBarComponent,
    RatingBarComponent,
    CountdownTimerComponent,
    ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
