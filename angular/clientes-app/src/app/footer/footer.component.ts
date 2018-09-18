import { Component } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent {
  /*definimos un atributo*/
  public autor:any = {nombre: 'Carlos Eduardo', apellido: 'Villanueva Altuna'};
}
