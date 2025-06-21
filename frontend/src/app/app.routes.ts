import { Routes } from '@angular/router';
import { DtComponent } from './components/dt/dt.component';
import { EquipoComponent } from './components/equipo/equipo.component';
import { JugadorComponent } from './components/jugador/jugador.component';
import { PaisComponent } from './components/pais/pais.component';
import { PosicionComponent } from './components/posicion/posicion.component';

export const routes: Routes = [
  { path: 'dt', component: DtComponent },
  { path: 'equipo', component: EquipoComponent },
  { path: 'jugador', component: JugadorComponent },
  { path: 'pais', component: PaisComponent },
  { path: 'posicion', component: PosicionComponent },
  { path: '', redirectTo: '/jugador', pathMatch: 'full' }, // Ruta por defecto
  { path: '**', redirectTo: '/jugador' } // Wildcard para rutas no encontradas
];
