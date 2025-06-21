import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router'; // RouterModule añadido

@Component({
  selector: 'app-root',
  standalone: true, // Añadido
  imports: [RouterOutlet, RouterModule], // RouterModule añadido a imports
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'frontend';
}
