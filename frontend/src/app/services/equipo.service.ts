import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Equipo } from '../models/equipo.model';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class EquipoService {

  private baseUrl = `${environment.apiBaseUrl}/equipos`;

  constructor(private http: HttpClient) {}

  // Obtener todos los equipos
  getAll(): Observable<Equipo[]> {
    return this.http.get<Equipo[]>(this.baseUrl);
  }

  // Crear un nuevo equipo
  create(equipo: Equipo): Observable<Equipo> {
    return this.http.post<Equipo>(this.baseUrl, equipo);
  }

  // Actualizar equipo existente
  update(id: number, equipo: Equipo): Observable<Equipo> {
    return this.http.put<Equipo>(`${this.baseUrl}/${id}`, equipo);
  }

  // Eliminar un equipo por ID
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
