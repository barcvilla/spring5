/*Clase especializada que maneja la logica del negocio relacionado con el Cliente. Esta Clase
  lee el arreglo de clientes json*/

import { CLIENTES } from './clientes.json'; //importamos la constante que se exporta del archivo cliente.json.ts
import { Injectable } from '@angular/core';
import { Cliente } from './cliente';
import { Observable, of } from 'rxjs'; //extensiones reactive (reactive extension)
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { map } from 'rxjs/operators';

//injectable marca la clase como una clase de servicio
@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  //definimos nuestro EndPoint (url)
  private urlEndPoint: string = "http://localhost:8080/api/clientes"; //apuntamos servidor Spring

  //definimos la cabecera
  private httpHeaders = new HttpHeaders({'Content-type':'application/json'});

  //definimos una variable http de clase en el constructor e inyectamos la dependencia HttpClient
  constructor(private http: HttpClient) { }

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
     //return of(CLIENTES);

     /**
     * El servidor nos envia una respuesta de tipo JSon, por lo que se debe hacer un Cast al tipo Cliente
     */
     //return this.http.get<Cliente[]>(this.urlEndPoint);

     // Otra forma es aplicar un map que nos permite convetir una respuesta Json a un tipo Cliente
     return this.http.get(this.urlEndPoint).pipe(
       //map(response => response as Cliente[]) usando clousure pero tambien podemos usar la manera antigua de function
       map(function(response) {
           return response as Cliente[];
       })
     );
  }

  /**
  * Metodo create() que recibe el cliente Json. Retorna un tipo Observable Cliente que es el cliente creado para ser
  * almacenado en la BD
  * Pasamos la URL, el objeto cliente y el headers
  */
  create(cliente: Cliente): Observable<Cliente>
  {
    return this.http.post<Cliente>(this.urlEndPoint, cliente, {headers: this.httpHeaders});
  }
}
