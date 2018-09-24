package com.bolsadeideas.springboot.app.view.pdf;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.bolsadeideas.springboot.app.models.entity.ItemFactura;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.pdf.collection.PdfCollection;

/**
 * Spring Bean FacturaPdfView
 * @author PC
 *
 */
@Component("factura/ver")
public class FacturaPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Factura factura = (Factura) model.get("factura");
		
		PdfPTable tabla = new PdfPTable(1);
		tabla.setSpacingAfter(20);
		
		//creamos una celda
		PdfPCell cell = null;
		
		//damos formato a la celda
		cell = new PdfPCell(new Phrase("Datos del Cliente"));
		cell.setBackgroundColor(new Color(184, 218, 255));
		cell.setPadding(8f);
		
		//adicionamos la celda a la tabla
		tabla.addCell(cell);
		
		tabla.addCell(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
		tabla.addCell(factura.getCliente().getEmail());
		
		PdfPTable tabla2 = new PdfPTable(1);
		tabla2.setSpacingAfter(20);
		
		cell = new PdfPCell(new Phrase("Datos de la Factura"));
		cell.setBackgroundColor(new Color(195, 230, 203));
		cell.setPadding(8f);
		tabla2.addCell(cell);
		tabla2.addCell("Numero: " + factura.getId());
		tabla2.addCell("Descripcion: " + factura.getDescripcion());
		tabla2.addCell("Feacha: " + factura.getCreateAt());
		
		//tabla 3 para el detalle de factura
		PdfPTable tabla3 = new PdfPTable(4);
		//dimension de la celda
		tabla3.setWidths(new float[] {2.5f, 1, 1, 1});
		//headers
		tabla3.addCell("Producto");
		tabla3.addCell("Precio");
		tabla3.addCell("Cantidad");
		tabla3.addCell("Total");
		
		//recorremos las lineas de la factura
		for(ItemFactura item : factura.getItems())
		{
			tabla3.addCell(item.getProducto().getNombre().toString());
			tabla3.addCell(item.getProducto().getPrecio().toString());
			
			cell = new PdfPCell(new Phrase(item.getCantidad().toString()));
			cell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			tabla3.addCell(cell);
			tabla3.addCell(item.calcularImporte().toString());
		}
		
		//footer
		cell = new PdfPCell(new Phrase("Total: "));
		cell.setColspan(3);
		cell.setHorizontalAlignment(PdfPCell.ALIGN_RIGHT);
		tabla3.addCell(cell);
		tabla3.addCell(factura.getTotal().toString());
		
		//guardamos las tablas en el documento pdf a crear
		document.add(tabla);
		document.add(tabla2);
		document.add(tabla3);
	}

}
