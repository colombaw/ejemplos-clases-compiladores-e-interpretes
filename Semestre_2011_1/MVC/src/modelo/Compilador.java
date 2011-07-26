package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Compilador extends Figura{

	private int ancho;
	
	private String fuente;
	private String objeto;
	private String implementacion;
	
	public Compilador(Point posicion, int ancho){
		this.posicion=posicion;
		this.ancho=ancho;
		this.seleccionada=false;  //Deberia estar en el constructor pero por simplicidad
		this.tipofigura=1;
		this.fuente="fuente";
		this.objeto="objeto";
		this.implementacion="imple";
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	
	
	public String getFuente() {
		return fuente;
	}

	public void setFuente(String fuente) {
		this.fuente = fuente;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public String getImplementacion() {
		return implementacion;
	}

	public void setImplementacion(String implementacion) {
		this.implementacion = implementacion;
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
				gpieza[i].setColor(Color.WHITE);
				gpieza[i].drawString(getNombre1(),this.getX()+5,(this.getY()+this.getAncho()/2)+5);
			}
			if(i==1){
				gpieza[i]=g;
				gpieza[i].setColor(Color.BLACK);
				gpieza[i].fillRect(this.getX()+this.ancho, this.getY(), this.getAncho(), this.getAncho());
			}
			if(i==2){
				gpieza[i]=g;
				gpieza[i].setColor(Color.BLACK);
				gpieza[i].fillRect(this.getX()+this.ancho*2, this.getY(), this.getAncho(), this.getAncho());
				gpieza[i].setColor(Color.WHITE);
				gpieza[i].drawString(getNombre2(),this.getX()+80,(this.getY()+this.getAncho()/2)+5);
			
			}
			if(i==3){
				gpieza[i]=g;
				gpieza[i].setColor(Color.BLACK);
				gpieza[i].fillRect(this.getX()+this.ancho, this.getY()+this.ancho, this.getAncho(), this.getAncho());
				gpieza[i].setColor(Color.WHITE);
				gpieza[i].drawString(getNombre3(),this.getX()+45,(this.getY()+this.getAncho()/2)+45);
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
					gpieza[i].fillRect(this.getX()+this.ancho, this.getY(), this.getAncho(), this.getAncho());
				}
				if(i==2){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillRect(this.getX()+this.ancho*2, this.getY(), this.getAncho(), this.getAncho());
				}
				if(i==3){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillRect(this.getX()+this.ancho, this.getY()+this.ancho, this.getAncho(), this.getAncho());
				}
				
			}
			
			
		}
		
		
		
		
	}


	@Override
	public String getNombre1() {
		// TODO Auto-generated method stub
		return fuente;
	}

	@Override
	public void setNombre1(String name) {
		// TODO Auto-generated method stub
		this.fuente=name;
	}

	@Override
	public String getNombre2() {
		// TODO Auto-generated method stub
		return objeto;
	}

	@Override
	public void setNombre2(String name) {
		// TODO Auto-generated method stub
		this.objeto=name;
	}

	@Override
	public String getNombre3() {
		// TODO Auto-generated method stub
		return implementacion;
	}

	@Override
	public void setNombre3(String name) {
		// TODO Auto-generated method stub
		this.implementacion=name;
	}



}
