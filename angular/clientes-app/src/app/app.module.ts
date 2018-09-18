/*Repositorio donde se registran nuestros components, pipes, class de servicios*/

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';

/*Importamos nuestro HeaderComponent*/
import { HeaderComponent } from './header/header.component';

import { FooterComponent } from './footer/footer.component';
import { DirectivaComponent } from './directiva/directiva.component';

@NgModule({
  /*Declaramos nuestros components*/
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirectivaComponent
  ],
  /*importamos modulos a utilizar: form, httpRequest, Rest, etc*/
  imports: [
    BrowserModule
  ],
  providers: [],
  /*component principal que despliega la aplicacion*/
  bootstrap: [AppComponent]
})
export class AppModule { }
