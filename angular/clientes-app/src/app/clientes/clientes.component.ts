import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente'; //importamos la clase Cliente

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html'
})
export class ClientesComponent implements OnInit {
  /*Creamos objetos cliente con formato JSon*/
  clientes: Cliente[] = [
    {id: 1, nombre: 'Andres', apellido: 'Guzman', email: 'a.guzman@gmail.com', createAt: '2017-12-11'},
    {id: 2, nombre: 'Carlos', apellido: 'Villanueva', email: 'barcvilla@gmail.com', createAt: '2018-09-19'}
  ];

  constructor() { }

  ngOnInit() {
  }

}
