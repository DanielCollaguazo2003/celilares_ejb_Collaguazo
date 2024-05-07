package ups.edu.ec.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Celular implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int codigo;
	private String IMEI;
	private String color;
	private String marca;
	private String modelo;
	private double precio;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Celular [codigo=" + codigo + ", IMEI=" + IMEI + ", color=" + color + ", marca=" + marca + ", modelo="
				+ modelo + ", precio=" + precio + "]";
	}

	

}
