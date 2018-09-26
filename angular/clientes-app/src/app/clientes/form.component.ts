import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { Router, ActivatedRoute } from '@angular/router';
import swal from 'sweetalert';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {
  //Creamos los atributos que se conectan con el front-end html
  private cliente: Cliente = new Cliente();
  private titulo: string = "Crear Cliente";

  //Inyecctamos el ClienteService para acceder al metodo create()
  constructor(private clienteService: ClienteService, private router: Router, private activateRoute: ActivatedRoute){

 }

  ngOnInit() {
    this.cargarCliente();
  }

  /**
  * Debemos obtener el Id, validarlo y si existe cargar los datos al objeto Cliente
  */
  cargarCliente(): void
  {
    //suscribimos un observador, que este observando cuando le pasamos un id
    this.activateRoute.params.subscribe(params => {
    let id = params['id']
    //el id existe?
    if(id)
    {
      //suscribimos el observador que asignara el cliente retornado de la BD a la variable de clase cliente
      this.clienteService.getCliente(id).subscribe((cliente)=> this.cliente = cliente);
    }
  })
  }

  update(): void
  {
    this.clienteService.update(this.cliente).subscribe(
      cliente => {
        this.router.navigate(['/clientes']);
        swal('Cliente actualizado', `Cliente ${cliente.nombre} actualizado con exito`, "success");
      }
    )
  }

  public create():void
  {
    this.clienteService.create(this.cliente).subscribe(
      cliente => {
        this.router.navigate(['/clientes']) // redireccionamos a la url vista de clientes
        swal('Nuevo Cliente', `El cliente ${cliente.nombre} creado con exito`, 'success');
      }
    );
  }

}
