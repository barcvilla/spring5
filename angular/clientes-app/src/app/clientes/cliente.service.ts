/*Clase especializada que maneja la logica del negocio relacionado con el Cliente. Esta Clase
  lee el arreglo de clientes json*/

import { CLIENTES } from './clientes.json'; //importamos la constante que se exporta del archivo cliente.json.ts
import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { Observable, of } from 'rxjs'; //extensiones reactive (reactive extension)

//injectable marca la clase como una clase de servicio
@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor() { }

  /**
  * Convertimos al metodo getClientes() en un metodo asincrono, que no bloque la app mientras espera la respuesta
  * del servidor.
  * El Patron Observer, se basa en un sujeto que es observado (cliente) y los observadores que se mantienen atentos
  * escuchando cualquier cambio en el sujeto observado, esto observadores se suscriben al sujeto y cuando cambia su estado
  * se notifica a los observadores y se dispara algun tipo de proceso o accion.
  * Este patron aplicado a Angular: En el backed tenemos un API REST y en el Front-end el cliente con Angular, asi
  * cuando se produce un cambio en el back-end se actulice en el cliente sin necesidad de recargar la pagina 
  */
  getClientes():Observable<Cliente[]>
  {
    /*convertimos al arreglo de clientes en un Observable*/
     return of(CLIENTES);
  }
}
