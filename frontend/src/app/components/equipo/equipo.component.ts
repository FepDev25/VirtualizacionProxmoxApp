import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Equipo } from '../../models/equipo.model';
import { EquipoService } from '../../services/equipo.service';

@Component({
  selector: 'app-equipo',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './equipo.component.html',
  styleUrl: './equipo.component.css'
})
export class EquipoComponent implements OnInit {
  equipos: Equipo[] = [];
  nuevoEquipo: Partial<Equipo> = { nombre: '', ciudad: '', fundacion: undefined };
  editandoId: number | null = null;

  constructor(private equipoService: EquipoService) {}

  ngOnInit(): void {
    this.obtenerEquipos();
  }

  obtenerEquipos(): void {
    this.equipoService.getAll().subscribe(data => this.equipos = data);
  }

  guardarEquipo(): void {
    if (this.editandoId !== null) {
      this.equipoService.update(this.editandoId, this.nuevoEquipo as Equipo).subscribe(() => {
        this.cancelarEdicion();
        this.obtenerEquipos();
      });
    } else {
      this.equipoService.create(this.nuevoEquipo as Equipo).subscribe(() => {
        this.nuevoEquipo = { nombre: '', ciudad: '', fundacion: undefined };
        this.obtenerEquipos();
      });
    }
  }

  editarEquipo(equipo: Equipo): void {
    this.nuevoEquipo = { ...equipo };
    this.editandoId = equipo.id;
  }

  cancelarEdicion(): void {
    this.nuevoEquipo = { nombre: '', ciudad: '', fundacion: undefined };
    this.editandoId = null;
  }

  eliminarEquipo(id: number): void {
    if (confirm('¿Estás seguro de eliminar este equipo?')) {
      this.equipoService.delete(id).subscribe(() => this.obtenerEquipos());
    }
  }
}
