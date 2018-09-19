/*Clase especializada que maneja la logica del negocio relacionado con el Cliente. Esta Clase
  lee el arreglo de clientes json*/

import { CLIENTES } from './clientes.json'; //importamos la constante que se exporta del archivo cliente.json.ts

import { Injectable } from '@angular/core';
import { Cliente } from './cliente';

//injectable marca la clase como una clase de servicio
@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor() { }

  getClientes():Cliente[]
  {
     return CLIENTES;
  }
}
