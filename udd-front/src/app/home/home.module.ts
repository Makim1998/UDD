import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeRoutingModule } from './home-routing.module';
import { HomeComponent } from './home.component';
import { PrijavaComponent } from './prijava/prijava.component';
import { RouterModule } from '@angular/router';
import { LayoutModule } from '../layout/layout.module';
import { ReactiveFormsModule } from '@angular/forms';
import { PretragaComponent } from './pretraga/pretraga.component';


@NgModule({
  declarations: [
    HomeComponent,
    PrijavaComponent,
    PretragaComponent
  ],
  imports: [
    CommonModule,
    RouterModule,
    LayoutModule,
    ReactiveFormsModule,
    HomeRoutingModule
  ],
  schemas: [ CUSTOM_ELEMENTS_SCHEMA ]
})
export class HomeModule { }
