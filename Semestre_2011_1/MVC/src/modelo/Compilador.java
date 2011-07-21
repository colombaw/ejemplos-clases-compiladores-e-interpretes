package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Compilador extends Figura{

	private int ancho;
	public Compilador(Point posicion, int ancho){
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
	/* calcular el area de la T :)*/
	/* ahora solo funciona el primer cuadro de la izquierda*/
	public boolean dentroFigura(Point p) {
		// TODO Auto-generated method stub
		int difX=Math.abs(p.x-(posicion.x+(ancho/2)));
		int difY=Math.abs(p.y-(posicion.y+(ancho/2)));
		return ( (difX<ancho/2) && (difY<ancho/2));
	}

	@Override
	/* Colocar label encima referente a */
	public void dibujar(Graphics g) {
		// TODO Auto-generated method stub
		// vector grafico 
		Graphics gpieza[] = null;
		gpieza = new Graphics[4];
		for(int i=0;i<4;i++){
			if(i==0){
				gpieza[i]=g;
				gpieza[i].setColor(Color.BLACK);
				gpieza[i].fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
			}
			if(i==1){
				gpieza[i]=g;
				gpieza[i].setColor(Color.BLACK);
				gpieza[i].fillRect(this.getX()+50, this.getY(), this.getAncho(), this.getAncho());
			}
			if(i==2){
				gpieza[i]=g;
				gpieza[i].setColor(Color.BLACK);
				gpieza[i].fillRect(this.getX()+100, this.getY(), this.getAncho(), this.getAncho());
			}
			if(i==3){
				gpieza[i]=g;
				gpieza[i].setColor(Color.BLACK);
				gpieza[i].fillRect(this.getX()+50, this.getY()+50, this.getAncho(), this.getAncho());
			}
			
			
		}
		/*se encarga de pintarla mientras este seleccinada :)*/
		/*  fuente       objeto  */
		/*     implementacion    */
		if(this.getSeleccionada()){
			//g.setColor(Color.RED);
			//g.drawRect(this.getX()+7, this.getY()+7, this.getAncho()-20, this.getAncho()-20);
			for(int i=0;i<4;i++){
				if(i==0){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
				}
				if(i==1){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillRect(this.getX()+50, this.getY(), this.getAncho(), this.getAncho());
				}
				if(i==2){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillRect(this.getX()+100, this.getY(), this.getAncho(), this.getAncho());
				}
				if(i==3){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillRect(this.getX()+50, this.getY()+50, this.getAncho(), this.getAncho());
				}
				
			}
			
			
		}
		
		
		
		
	}



}
