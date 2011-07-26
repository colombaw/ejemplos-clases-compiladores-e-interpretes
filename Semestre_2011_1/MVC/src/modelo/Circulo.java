package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Circulo extends Figura {

	private int radio;
	
	public void setRadio(int ancho){
		this.radio=ancho;
	}
	
	public int getRadio(){
		return radio;
	}
	
	public Circulo(Point posicion, int radio){
		this.posicion=posicion;
		this.radio=radio;
		this.seleccionada=false;  //Deberia estar en el constructor de figura pero por simplicidad
	}
	
	@Override
	
	/*revisar dentro de la figura */
	public boolean dentroFigura(Point p) {
		if ( radio >= Math.sqrt( Math.pow( p.x - posicion.x,2 ) + Math.pow(p.y - posicion.y, 2 )))		
				return true;
		else
				return false;
	}

	@Override
	public void dibujar(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillOval(this.getX(), this.getY(), this.getRadio(), this.getRadio());
		if(this.getSeleccionada()){
			g.setColor(Color.CYAN);
			g.drawOval(this.getX()+7, this.getY()+7, this.getRadio()-20, this.getRadio()-20);
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
