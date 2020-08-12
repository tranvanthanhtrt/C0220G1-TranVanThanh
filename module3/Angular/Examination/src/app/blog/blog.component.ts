import {Component, OnInit} from '@angular/core';
import {Blog} from '../blog';
import {BlogService} from '../blog.service';

@Component({
    selector: 'app-blog',
    templateUrl: './blog.component.html',
    styleUrls: ['./blog.component.scss']
})
export class BlogComponent implements OnInit {
    blogs: Blog[] = [];
    constructor(private blogService: BlogService) {
        this.blogService.findAllBlog().subscribe(
            next => {
                this.blogs = next;
            },
            error => {
                this.blogs = [];
                console.log(error);
            });
    }

    ngOnInit(): void {
    }

}
