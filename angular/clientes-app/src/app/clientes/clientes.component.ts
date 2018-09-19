import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente'; //importamos la clase Cliente
import { ClienteService } from './cliente.service';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html'
})
export class ClientesComponent implements OnInit {
  private clientes: Cliente[];
  private clienteService: ClienteService;

  constructor(clienteService: ClienteService) {
    this.clienteService = clienteService;
  }

  ngOnInit() {
    //registramos el observador al cliente para que escuche las modificaciones
    this.clienteService.getClientes().subscribe(
    //funcion anonima donde declaramos nuestro observador. Pasamos el array de clientes y lo asignamos a la variable de instancia
    (clientes) =>
    {
      this.clientes = clientes
    }
  );
  }

}
