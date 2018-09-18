import { Component } from '@angular/core';

@Component({
  /*selector:app-root llama a la clase AppComponent*/
  selector: 'app-root',
  /*vista de la clase AppComponent*/
  templateUrl: './app.component.html',
  /*hoja de estilos de AppComponent*/
  styleUrls: ['./app.component.css']
})
/*Clase AppComponent que representa una parte de la app, se puede parecer al spring controller*/
export class AppComponent {
  title = 'Bienvenidos a Angular';
  curso:string = "Angular con Spring 5.0";
  alumno: string = "Carlos Eduardo Villanueva Altuna";
}
