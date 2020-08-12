import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {SinhvienComponent} from './sinhvien/sinhvien.component';
import {SinhvienEditComponent} from './sinhvien/sinhvien-edit/sinhvien-edit.component';
import {BlogComponent} from './blog/blog.component';


const routes: Routes = [
  {
    path: 'sinhViens',
    component: SinhvienComponent
  },

  {
    path: 'sinhViens/:id/chinhSua',
    component: SinhvienEditComponent
  },
  {
    path: 'blogs',
    component: BlogComponent
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
