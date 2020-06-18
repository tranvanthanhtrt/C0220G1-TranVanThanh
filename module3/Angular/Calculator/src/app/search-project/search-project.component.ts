import {Component, OnInit} from '@angular/core';
import {listProject} from './listProject';

@Component({
  selector: 'app-search-project',
  templateUrl: './search-project.component.html',
  styleUrls: ['./search-project.component.css']
})
export class SearchProjectComponent implements OnInit {
  listProject = listProject;
  searchKey: string;

  constructor() {
  }

  onSearch(): void {
    // tslint:disable-next-line:prefer-const
    let mylist = this.listProject;
    mylist.splice(0, mylist.length);
    // tslint:disable-next-line:no-shadowed-variable
    function httpGet(url: string): Promise<any> {
      // tslint:disable-next-line:only-arrow-functions
      return new Promise(function(resolve, reject) {
        const request = new XMLHttpRequest();
        request.onload = function() {
          if (this.status === 200) {
            // Success
            resolve(this.response);
          } else {
            // Something went wrong (404 etc.)
            reject(new Error(this.statusText));
          }
        };
        request.onerror = function() {
          reject(new Error('XMLHttpRequest Error: ' + this.statusText));
        };
        request.open('GET', url);
        request.send();
      });
    }
    const inputValue = this.searchKey;
    const url = 'https://api.github.com/search/repositories?q=' + inputValue;
    httpGet(url).then(
      // tslint:disable-next-line:only-arrow-functions
      function(value) {
        const object = JSON.parse(value);
        const items = object.items;
        // tslint:disable-next-line:prefer-for-of
        for (let i = 0; i < items.length; i++) {
          mylist.push({name: items[i].name, url: items[i].html_url });
        }
      },
      // tslint:disable-next-line:only-arrow-functions
      function(reason) {
        console.error('Something went wrong', reason);
      }
    );
  }
  ngOnInit(): void {
  }

}
