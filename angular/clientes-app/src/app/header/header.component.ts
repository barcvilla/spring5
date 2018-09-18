import { Component } from '@angular/core';
/*Una vez creado el HeaderComponent este debe importarse en el archivo app.module.ts*/
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html' /*string que apunta a la plantilla html*/
})
export class HeaderComponent{
  title:string = 'App-Angular';
}
