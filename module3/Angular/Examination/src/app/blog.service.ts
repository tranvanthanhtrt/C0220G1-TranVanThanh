import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Blog} from './blog';

@Injectable({
  providedIn: 'root'
})

export class BlogService {
BLOG_URL = 'http://localhost:8081/rest-blogs/content';
  constructor( private httpClient: HttpClient) {}

    findAllBlog(): Observable<Blog[]>{
return this.httpClient.get<Blog[]>(this.BLOG_URL);

  }
}
