import { Cliente } from './cliente'; //importamos la clase Cliente

/*Creamos objetos cliente con formato JSon. Marcamos como export para poder exportar*/
export const CLIENTES: Cliente[] = [
  {id: 1, nombre: 'Andres', apellido: 'Guzman', email: 'a.guzman@gmail.com', createAt: '2017-12-11'},
  {id: 2, nombre: 'Carlos', apellido: 'Villanueva', email: 'barcvilla@gmail.com', createAt: '2018-09-19'},
  {id: 3, nombre: 'Maria', apellido: 'Jiminez', email: 'm.jimenez@gmail.com', createAt: '2018-09-19'}
];
