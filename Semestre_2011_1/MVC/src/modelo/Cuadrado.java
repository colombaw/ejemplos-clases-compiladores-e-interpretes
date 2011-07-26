package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Cuadrado extends Figura {

	private int ancho;
	public Cuadrado(Point posicion, int ancho){
		this.posicion=posicion;
		this.ancho=ancho;
		this.seleccionada=false;  //Deberia estar en el constructor pero por simplicidad
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	@Override
	//Muy rudimentario y solo a modo demostrativo, para uso serio debe ser mejorada
	public boolean dentroFigura(Point p) {
		int difX=Math.abs(p.x-(posicion.x+(ancho/2)));
		int difY=Math.abs(p.y-(posicion.y+(ancho/2)));
		return ( (difX<ancho/2) && (difY<ancho/2));   
		
	}
	
	@Override
	public void dibujar(Graphics g)
	{
		g.setColor(Color.BLUE);
		g.fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
		if(this.getSeleccionada()){
			g.setColor(Color.RED);
			g.drawRect(this.getX()+7, this.getY()+7, this.getAncho()-20, this.getAncho()-20);
		}
	}



	@Override
	public String getNombre1() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNombre1(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombre2() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNombre2(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getNombre3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setNombre3(String name) {
		// TODO Auto-generated method stub
		
	}	
}
