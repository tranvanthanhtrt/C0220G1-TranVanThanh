import {Component, Input, OnChanges, OnDestroy, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-countdown-timer',
  templateUrl: './countdown-timer.component.html',
  styleUrls: ['./countdown-timer.component.css']
})
export class CountdownTimerComponent implements OnChanges , OnInit , OnDestroy{
  intervalID = 0;
  message = '';
  remainingTime: number;
  @Input()
  second = 11;
  ngOnChanges(changes: SimpleChanges) {
    if ('second' in changes) {
      let v = changes.second.currentValue;
      v = typeof v === 'undefined' ? 11 : v;
      const vFixed = Number(v);
      this.second = Number.isNaN(vFixed) ? 11 : vFixed;
    }
  }
  constructor() {
  }

  clearTime() {
    clearInterval(this.intervalID);
  }

  start() {
    this.countDown();
    if (this.remainingTime <= 0) {
      this.remainingTime = this.second;
    }

  }

  stop() {
    this.clearTime();
    this.message = 'pause at ' + this.remainingTime;
  }

  reset() {
    this.clearTime();
    this.remainingTime = this.second;
    this.message = 'Click Start to countdown';
  }

  countDown() {
    this.clearTime();
    this.intervalID = window.setInterval(() => {
        this.remainingTime -= 1;
        if (this.remainingTime === 0) {
          this.message = 'finish!';
          this.clearTime();
        } else {
          this.message = this.remainingTime + ' second remaining !';
        }
      }
      , 1000);
  }
  ngOnDestroy() {
    this.clearTime();
  }
  ngOnInit(): void {
    this.reset();
    this.start();
  }

}
