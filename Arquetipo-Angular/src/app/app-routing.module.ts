import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { TecnologiaComponent } from './tecnologia/tecnologia.component';
import { CapacidadComponent } from './capacidad/capacidad.component';
import { BootcampComponent } from './bootcamp/bootcamp.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'tecnologia',
    pathMatch: 'full',
  },
  {
    path: 'tecnologia',
    component: TecnologiaComponent,
  },
  {
    path: 'capacidades',
    component: CapacidadComponent,
  },
  {
    path: 'bootcamp',
    component: BootcampComponent,
  },
  {
    path: '**',
    redirectTo: 'tecnologia',
  },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes),
  ],
  exports: [
    RouterModule,
  ],
})
export class AppRoutingModule {
}
