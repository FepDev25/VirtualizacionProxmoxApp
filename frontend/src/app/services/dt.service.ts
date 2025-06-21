import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../environment/environment.prod';
import { Observable } from 'rxjs';

export interface DtDTO {
  id?: number; // opcional para creación
  nombre: string;
  paisId: number;
  equipoId: number;
}

@Injectable({
  providedIn: 'root'
})
export class DtService {

  private baseUrl = `${environment.apiBaseUrl}/dts`;

  constructor(private http: HttpClient) {}

  // Obtener todos los DTs
  getAll(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  // Obtener un DT por ID
  getById(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  // Crear un nuevo DT
  create(dt: DtDTO): Observable<any> {
    return this.http.post<any>(this.baseUrl, dt);
  }

  // Actualizar un DT existente
  update(id: number, dt: DtDTO): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}/${id}`, dt);
  }

  // Eliminar un DT
  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
