import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService } from './cliente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html'
})
export class FormComponent implements OnInit {
  //Creamos los atributos que se conectan con el front-end html
  private cliente: Cliente = new Cliente();
  private titulo: string = "Crear Cliente";

  //Inyecctamos el ClienteService para acceder al metodo create()
  constructor(private clienteService: ClienteService, private router: Router) { }

  ngOnInit() {
  }

  public create():void
  {
    this.clienteService.create(this.cliente).subscribe(
      response => this.router.navigate(['/clientes']) // redireccionamos a la url vista de clientes
    )
  }

}
