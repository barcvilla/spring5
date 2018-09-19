/*Repositorio donde se registran nuestros components, pipes, class de servicios*/

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

/*Importamos nuestro HeaderComponent*/
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { DirectivaComponent } from './directiva/directiva.component';
import { ClientesComponent } from './clientes/clientes.component';
import { ClienteService } from './clientes/cliente.service'; /*Importamos nuestra clase cliente.service*/

@NgModule({
  /*Declaramos nuestros components*/
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirectivaComponent,
    ClientesComponent
  ],
  /*importamos modulos a utilizar: form, httpRequest, Rest, etc*/
  imports: [
    BrowserModule
  ],
  providers: [ClienteService],
  /*component principal que despliega la aplicacion*/
  bootstrap: [AppComponent]
})
export class AppModule { }
