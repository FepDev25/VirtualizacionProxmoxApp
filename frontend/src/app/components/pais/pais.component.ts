import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PaisService } from '../../services/pais.service';
import { Pais } from '../../models/pais.model';

@Component({
  selector: 'app-pais',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './pais.component.html',
  styleUrl: './pais.component.css'
})
export class PaisComponent implements OnInit {
  paises: Pais[] = [];
  nuevoPais: Partial<Pais> = { nombre: '' };

  constructor(private paisService: PaisService) {}

  ngOnInit(): void {
    this.obtenerPaises();
  }

  obtenerPaises(): void {
    this.paisService.getAll().subscribe(data => this.paises = data);
  }

  guardarPais(): void {
    if (this.nuevoPais.nombre?.trim()) {
      this.paisService.create(this.nuevoPais as Pais).subscribe(() => {
        this.nuevoPais.nombre = '';
        this.obtenerPaises();
      });
    }
  }
}
