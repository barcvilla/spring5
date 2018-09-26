import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente'; //importamos la clase Cliente
import { ClienteService } from './cliente.service';
import swal from 'sweetalert2';

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

  //metodo delete() desde la vista de cliente
  delete(cliente: Cliente): void{
  const swalWithBootstrapButtons = swal.mixin({
  confirmButtonClass: 'btn btn-success',
  cancelButtonClass: 'btn btn-danger',
  buttonsStyling: false,
})

swalWithBootstrapButtons({
  title: 'Esta seguro?',
  text: `Esta seguro de eliminar al cliente ${cliente.nombre} ${cliente.apellido}?`,
  type: 'warning',
  showCancelButton: true,
  confirmButtonText: 'Si, eliminar!',
  cancelButtonText: 'No, cancelar!',
  reverseButtons: true
}).then((result) => {
  if (result.value) {
    this.clienteService.delete(cliente.id).subscribe(
      response =>{
        //quitamos del listado, el cliente eliminado
        //filtramos, incluimos en la lista todos los clientes que no sean igual al cliente a eliminar, si el
        // cliente a eliminar es igual al cliente en la lista no lo incluimos en el list a mostrarse en la vista
        this.clientes = this.clientes.filter(cli => cli != cliente);
        swalWithBootstrapButtons(
          'Cliente eliminado!',
          `Cliente ${cliente.nombre} ${cliente.apellido} eliminado con exito`,
          'success'
        )
      }
    )
  }
})
}

}
