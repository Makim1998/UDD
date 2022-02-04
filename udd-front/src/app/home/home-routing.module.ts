import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { REQUEST_PATH } from '../constants/routes';
import { HomeComponent } from './home.component';
import { PrijavaComponent } from './prijava/prijava.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent,
    children: [
      {
        path: REQUEST_PATH,
        component: PrijavaComponent
      },
    ]
},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
