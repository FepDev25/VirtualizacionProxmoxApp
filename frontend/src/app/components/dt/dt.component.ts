import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Pais } from '../../models/pais.model';
import { Equipo } from '../../models/equipo.model';
import { DtDTO, DtService } from '../../services/dt.service';
import { PaisService } from '../../services/pais.service';
import { EquipoService } from '../../services/equipo.service';

@Component({
  selector: 'app-dt',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './dt.component.html',
  styleUrl: './dt.component.css'
})
export class DtComponent implements OnInit {
  dts: any[] = [];
  paises: Pais[] = [];
  equipos: Equipo[] = [];
  nuevoDt: Partial<DtDTO> = { nombre: '', paisId: 0, equipoId: 0 };
  editandoId: number | null = null;

  constructor(
    private dtService: DtService,
    private paisService: PaisService,
    private equipoService: EquipoService
  ) {}

  ngOnInit(): void {
    this.obtenerDts();
    this.paisService.getAll().subscribe(data => this.paises = data);
    this.equipoService.getAll().subscribe(data => this.equipos = data);
  }

  obtenerDts(): void {
    this.dtService.getAll().subscribe(data => this.dts = data);
  }

  guardarDt(): void {
    if (this.editandoId !== null) {
      this.dtService.update(this.editandoId, this.nuevoDt as DtDTO).subscribe(() => {
        this.cancelarEdicion();
        this.obtenerDts();
      });
    } else {
      this.dtService.create(this.nuevoDt as DtDTO).subscribe(() => {
        this.nuevoDt = { nombre: '', paisId: 0, equipoId: 0 };
        this.obtenerDts();
      });
    }
  }

  editarDt(dt: any): void {
    this.nuevoDt = {
      id: dt.id,
      nombre: dt.nombre,
      paisId: dt.pais?.id,
      equipoId: dt.equipo?.id
    };
    this.editandoId = dt.id;
  }

  cancelarEdicion(): void {
    this.nuevoDt = { nombre: '', paisId: 0, equipoId: 0 };
    this.editandoId = null;
  }

  eliminarDt(id: number): void {
    if (confirm('¿Eliminar este DT?')) {
      this.dtService.delete(id).subscribe(() => this.obtenerDts());
    }
  }
}
