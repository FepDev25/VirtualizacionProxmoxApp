import { Component } from '@angular/core';
import { CommonModule } from '@angular/common'; // Importar CommonModule para directivas básicas

@Component({
  selector: 'app-dt',
  standalone: true, // Marcar como standalone
  imports: [CommonModule], // Importar CommonModule aquí
  templateUrl: './dt.component.html',
  styleUrl: './dt.component.css'
})
export class DtComponent {

}
