import { Component, OnInit } from '@angular/core';
import {DictionaryService} from "../dictionary.service";
import {Route, Router} from "@angular/router";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.scss']
})
export class DictionaryPageComponent implements OnInit {
wordSearch: string;
  constructor(public dictionaryService: DictionaryService, private router: Router) {
  }

  ngOnInit(): void {
  }

  search(value: string) {
    this.wordSearch=value;

    this.router.navigate(['/dictionary',this.wordSearch])

  }
}
