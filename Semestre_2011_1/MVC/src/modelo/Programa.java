package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Programa extends Figura {

	private int ancho;
	private int radio;
	public Programa(Point posicion, int ancho){
		this.posicion=posicion;
		this.ancho=ancho;
		this.radio=ancho;
		this.seleccionada=false;  //Deberia estar en el constructor pero por simplicidad
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	
	
	@Override
	/* calcular el area de la figura circulo + cuadrado mejorar */
	public boolean dentroFigura(Point p) {
		// TODO Auto-generated method stub
		if ( radio >= Math.sqrt( Math.pow( p.x - posicion.x,2 ) + Math.pow(p.y - posicion.y, 2 ))){		
			
			/*int difX=Math.abs(p.x-(posicion.x+(ancho/2)));
			int difY=Math.abs(p.y-(posicion.y+(ancho/2)));
			return ( (difX<ancho/2) && (difY<ancho/2));*/
			return true;
			
			}
		
	else{
		
		
			return false;}
		
		
	}

	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		//
		/*g.setColor(Color.BLUE);
		g.fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
		if(this.getSeleccionada()){
			g.setColor(Color.RED);
			g.drawRect(this.getX()+7, this.getY()+7, this.getAncho()-20, this.getAncho()-20);
		}*/
		Graphics gpieza[] = null;
		gpieza = new Graphics[2];
		for(int i=0;i<2;i++){
			if(i==0){
				gpieza[i]=g;
				gpieza[i].setColor(Color.RED);
				gpieza[i].fillOval(this.getX(), this.getY(), 70,70);
			}
			if(i==1){
				gpieza[i]=g;
				gpieza[i].setColor(Color.RED);
				gpieza[i].fillRect(this.getX()+10, this.getY()+60, this.getAncho(), this.getAncho());
			}
		}	
		
		
		if(this.getSeleccionada()){
			
			for(int i=0;i<2;i++){
				if(i==0){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillOval(this.getX(), this.getY(), 70,70);
				}
				if(i==1){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillRect(this.getX()+10, this.getY()+60, this.getAncho(), this.getAncho());
				}
			}
			
			
		}
		
		
		
	}

}
