import { Pais } from './pais.model';
import { Posicion } from './posicion.model';
import { Equipo } from './equipo.model';

export interface Jugador {
  id: number;
  nombre: string;
  edad: number;
  equipo: Equipo;
  pais: Pais;
  posicion: Posicion;
}
