import { Pais } from './pais.model';
import { Equipo } from './equipo.model';

export interface Dt {
  id: number;
  nombre: string;
  pais: Pais;
  equipo: Equipo;
}
