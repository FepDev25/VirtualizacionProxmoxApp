import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environment/environment.prod';
import { Observable } from 'rxjs';

export interface JugadorDTO {
  id?: number;
  nombre: string;
  edad: number;
  paisId: number;
  equipoId: number;
  posicionId: number;
}

@Injectable({
  providedIn: 'root'
})
export class JugadorService {

  private baseUrl = `${environment.apiBaseUrl}/jugadores`;

  constructor(private http: HttpClient) {}

  // Obtener todos los jugadores
  getAll(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  // Obtener un jugador por ID
  getById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  // Crear jugador
  create(jugador: JugadorDTO): Observable<any> {
    return this.http.post<any>(this.baseUrl, jugador);
  }

  // Actualizar jugador
  update(id: number, jugador: JugadorDTO): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/${id}`, jugador);
  }

  // Eliminar jugador
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
