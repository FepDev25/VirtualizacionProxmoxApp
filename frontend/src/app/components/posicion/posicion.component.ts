import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Posicion } from '../../models/posicion.model';
import { PosicionService } from '../../services/posicion.service';

@Component({
  selector: 'app-posicion',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './posicion.component.html',
  styleUrl: './posicion.component.css'
})
export class PosicionComponent implements OnInit {
  posiciones: Posicion[] = [];
  nuevaPosicion: Partial<Posicion> = { nombre: '' };

  constructor(private posicionService: PosicionService) {}

  ngOnInit(): void {
    this.obtenerPosiciones();
  }

  obtenerPosiciones(): void {
    this.posicionService.getAll().subscribe(data => this.posiciones = data);
  }

  guardarPosicion(): void {
    if (this.nuevaPosicion.nombre?.trim()) {
      this.posicionService.create(this.nuevaPosicion as Posicion).subscribe(() => {
        this.nuevaPosicion.nombre = '';
        this.obtenerPosiciones();
      });
    }
  }
}
