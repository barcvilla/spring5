import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Bienvenidos a Angular';
  curso:string = "Angular con Spring 5.0";
  Alumno: string = "Carlos Eduardo Villanueva Altuna";
}
