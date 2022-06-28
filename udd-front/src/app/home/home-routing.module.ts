import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { REQUEST_PATH, SEARCH_PATH } from '../constants/routes';
import { HomeComponent } from './home.component';
import { PretragaComponent } from './pretraga/pretraga.component';
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
      {
        path: SEARCH_PATH,
        component: PretragaComponent
      },
    ]
},];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class HomeRoutingModule { }
