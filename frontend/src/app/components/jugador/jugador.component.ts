import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Posicion } from '../../models/posicion.model';
import { Equipo } from '../../models/equipo.model';
import { Pais } from '../../models/pais.model';
import { JugadorDTO, JugadorService } from '../../services/jugador.service';
import { EquipoService } from '../../services/equipo.service';
import { PaisService } from '../../services/pais.service';
import { PosicionService } from '../../services/posicion.service';


@Component({
  selector: 'app-jugador',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './jugador.component.html',
  styleUrl: './jugador.component.css'
})
export class JugadorComponent implements OnInit {
  jugadores: any[] = [];
  paises: Pais[] = [];
  equipos: Equipo[] = [];
  posiciones: Posicion[] = [];
  nuevoJugador: Partial<JugadorDTO> = { nombre: '', edad: 0, paisId: 0, equipoId: 0, posicionId: 0 };
  editandoId: number | null = null;

  constructor(
    private jugadorService: JugadorService,
    private paisService: PaisService,
    private equipoService: EquipoService,
    private posicionService: PosicionService
  ) {}

  ngOnInit(): void {
    this.obtenerJugadores();
    this.paisService.getAll().subscribe(data => this.paises = data);
    this.equipoService.getAll().subscribe(data => this.equipos = data);
    this.posicionService.getAll().subscribe(data => this.posiciones = data);
  }

  obtenerJugadores(): void {
    this.jugadorService.getAll().subscribe(data => this.jugadores = data);
  }

  guardarJugador(): void {
    if (this.editandoId !== null) {
      this.jugadorService.update(this.editandoId, this.nuevoJugador as JugadorDTO).subscribe(() => {
        this.cancelarEdicion();
        this.obtenerJugadores();
      });
    } else {
      this.jugadorService.create(this.nuevoJugador as JugadorDTO).subscribe(() => {
        this.nuevoJugador = { nombre: '', edad: 0, paisId: 0, equipoId: 0, posicionId: 0 };
        this.obtenerJugadores();
      });
    }
  }

  editarJugador(jugador: any): void {
    this.nuevoJugador = {
      id: jugador.id,
      nombre: jugador.nombre,
      edad: jugador.edad,
      paisId: jugador.pais?.id,
      equipoId: jugador.equipo?.id,
      posicionId: jugador.posicion?.id
    };
    this.editandoId = jugador.id;
  }

  cancelarEdicion(): void {
    this.nuevoJugador = { nombre: '', edad: 0, paisId: 0, equipoId: 0, posicionId: 0 };
    this.editandoId = null;
  }

  eliminarJugador(id: number): void {
    if (confirm('¿Eliminar este jugador?')) {
      this.jugadorService.delete(id).subscribe(() => this.obtenerJugadores());
    }
  }
}
