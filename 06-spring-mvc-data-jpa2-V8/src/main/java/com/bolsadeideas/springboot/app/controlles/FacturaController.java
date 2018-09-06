package com.bolsadeideas.springboot.app.controlles;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.service.IClienteService;

@Controller
@SessionAttributes("factura") //mantenemos el objeto factura dentro de una session hasta que se procesa el formulario y se envia al metodo guardar. Metodo Guardar persite la factura en la BD
@RequestMapping("/factura")
public class FacturaController 
{
	@Autowired
	private IClienteService clienteService;
	
	// Metodo que despliega el formulario Factura en la vista
	@GetMapping("/form/{clienteId}")
	public String crear(@PathVariable(value="clienteId") Long clienteId, Map<String, Object> model, RedirectAttributes flash)
	{
		Cliente cliente = clienteService.findOne(clienteId);
		if(cliente == null)
		{
			flash.addFlashAttribute("error", "El cliente no existen en la Base de Datos");
			return "redirect:/listar";
		}
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		
		//A traves del model pasamos el objeto factura a la vista  form.html
		model.put("factura", factura);
		model.put("titulo", "Crear factura");
		
		return "factura/form";
	}
}
