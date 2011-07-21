package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Maquina extends Figura {

	private int ancho;
	
	public Maquina(Point posicion, int ancho){
		this.posicion=posicion;
		this.ancho=ancho;
		this.seleccionada=false;  
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	
	
	@Override
	public boolean dentroFigura(Point p) {
		// TODO Auto-generated method stub
		int difX=Math.abs(p.x-(posicion.x+(ancho/2)));
		int difY=Math.abs(p.y-(posicion.y+(ancho/2)));
		return ( (difX<ancho/2) && (difY<(ancho*2)/2));

	}

	@Override
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		Graphics gpieza[] = null;
		gpieza = new Graphics[2];
		
		for(int i=0;i<2;i++){
			if(i==0){
				gpieza[i]=g;
				
				gpieza[i].setColor(Color.BLACK);
				gpieza[i].fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
				gpieza[i].setColor(Color.GREEN);
				/// pasar el texto de las las pantallas 
				gpieza[i].drawString("h1",this.getX()+20,this.getY()+25);
			}
			if(i==1){
				
				//colocar icono en la parte de abajo :)
				
				gpieza[i]=g;
				//g2d.draw(this.getX(), this.getY(), this.getAncho(), this.getAncho() );
				
				gpieza[i].setColor(Color.gray);
				gpieza[i].fillRect(this.getX(), this.getY()+50, this.getAncho(), this.getAncho());
				gpieza[i].setColor(Color.GREEN);
				/// pasar el texto de las las pantallas 
				gpieza[i].drawString("h2",this.getX()+20,this.getY()+75);
			}
		}
		
		
		
	}

}
