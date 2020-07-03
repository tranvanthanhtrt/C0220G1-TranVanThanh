import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from "rxjs";
import {DictionaryService} from "../dictionary.service";
import {ActivatedRoute, ParamMap} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.scss']
})
export class DictionaryDetailComponent implements OnInit, OnDestroy {
  word: any;
  sub: Subscription;

  constructor(
    private dictionaryService: DictionaryService,
    private activatedRoute: ActivatedRoute
  ) {
  }

  ngOnInit() {
    this.sub = this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      const eng = paramMap.get('eng');
      this.word = this.dictionaryService.find(eng);
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
