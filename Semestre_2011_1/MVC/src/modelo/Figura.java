package modelo;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Figura {

	protected int tipofigura;
	protected Point posicion;
	protected boolean seleccionada;
	public abstract boolean dentroFigura(Point p);
	public abstract void dibujar(Graphics g);	
	
	//*metodo para extraer nombre 1 de la figura*//
	public abstract String getNombre1();
	public abstract void setNombre1(String name);
	
	//*metodo para extraer nombre 2 de la figura*//
	public abstract String getNombre2();
	public abstract void setNombre2(String name);
	
	//*metodo para extraer nombre 3 de la figura*//
	public abstract String getNombre3();
	public abstract void setNombre3(String name);
	
	
	public void setPosicion(Point posicion)
	{
		this.posicion=posicion;
	}
	
	public int getX(){
		return posicion.x;
	}
	
	public int getY(){
		return posicion.y;
	}
	/*retorna el tipo de figura para saber que menu llamar*/
	public int GetTipofigura(){
		return tipofigura;
	}
	
	public void SetTipofigura(int tipof){
		tipofigura = tipof;
	}

	
	

	Point getPosicion(){
		return posicion;
	}
	
	public boolean getSeleccionada(){
		return seleccionada;
	}

	public void setSeleccionada(boolean sel){
		seleccionada=sel;
	}

}
