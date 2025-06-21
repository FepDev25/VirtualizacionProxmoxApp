import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Posicion } from '../models/posicion.model';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class PosicionService {

  private baseUrl = `${environment.apiBaseUrl}/posiciones`;

  constructor(private http: HttpClient) {}

  // Obtener todas las posiciones
  getAll(): Observable<Posicion[]> {
    return this.http.get<Posicion[]>(this.baseUrl);
  }

  // Obtener una posición por ID
  getById(id: number): Observable<Posicion> {
    return this.http.get<Posicion>(`${this.baseUrl}/${id}`);
  }

  // Crear nueva posición
  create(posicion: Posicion): Observable<Posicion> {
    return this.http.post<Posicion>(this.baseUrl, posicion);
  }
}
