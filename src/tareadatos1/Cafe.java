/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareadatos1;

/**
 *
 * @author zepeda
 */
public class Cafe {
    
      private String nombre;
	private int proveedorId;
	private float precio;
	private int ventas;
	private int total;
        

    public Cafe() {
    }

    public Cafe(String nombre, int proveedorId, float precio, int ventas, int total) {
        this.nombre = nombre;
        this.proveedorId = proveedorId;
        this.precio = precio;
        this.ventas = ventas;
        this.total = total;
       
    }
    
 
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getProveedorId() {
		return proveedorId;
	}

	public void setProveedorId(int proveedorId) {
		this.proveedorId = proveedorId;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	 @Override
	    public String toString() {
	        return "Cafe " + "nombre= " + nombre + " precio= " + precio+ " ventas= " + ventas + " "
                        + "total= " + total + "\n";
	    }

    
}
