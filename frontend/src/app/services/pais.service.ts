import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Pais } from '../models/pais.model';
import { Observable } from 'rxjs';
import { environment } from '../../environment/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class PaisService {

  private baseUrl = `${environment.apiBaseUrl}/paises`;

  constructor(private http: HttpClient) {}

  // Obtener todos los países
  getAll(): Observable<Pais[]> {
    return this.http.get<Pais[]>(this.baseUrl);
  }

  // Obtener un país por su ID
  getById(id: number): Observable<Pais> {
    return this.http.get<Pais>(`${this.baseUrl}/${id}`);
  }

  // Crear un nuevo país
  create(pais: Pais): Observable<Pais> {
    return this.http.post<Pais>(this.baseUrl, pais);
  }
}
