import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ImageGalleryComponent} from "./image-gallery/image-gallery.component";


const routes: Routes = [
  { path: 'image-gallery',
    component: ImageGalleryComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
