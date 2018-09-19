import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente'; //importamos la clase Cliente
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html'
})
export class ClientesComponent implements OnInit {
  clientes: Cliente[];
  private clienteService: ClienteService;

  constructor(clienteService: ClienteService) {
    this.clienteService = clienteService;
  }

  ngOnInit() {
    //iniciamos la variable array clientes son la constante exportada ClientesComponent
    this.clientes = this.clienteService.getClientes();
  }

}
