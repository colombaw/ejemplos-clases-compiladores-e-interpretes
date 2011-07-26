package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Programa extends Figura {

	private int ancho;
	private int radio;
	private int ratiomod;
	private String programa;
	private String lenguaje;
	
	
	public Programa(Point posicion, int ancho){
		this.posicion=posicion;
		this.ancho=ancho;
		this.radio=ancho+10;
		this.ratiomod=ancho;
		this.seleccionada=false;  //Deberia estar en el constructor pero por simplicidad
		this.tipofigura=2;
		this.programa="Prog";
		this.lenguaje="Leng";
	}
	
	
	public void setPrograma(String pro){
		this.programa=pro;
	}
	public String getPrograma(){
		return programa;
	}
	
	public void setlenguaje(String le){
		this.lenguaje=le;
	}
	public String getlenguaje(){
		return lenguaje;
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	
	
	
	
	
	public void setRadio(int ancho){
		this.radio=ancho;
	}
	
	public int getRadio(){
		return radio;
	}
	
	
	@Override
	/* calcular el area de la figura circulo + cuadrado mejorar */
	public boolean dentroFigura(Point p) {
		// TODO Auto-generated method stub
		int difX=Math.abs(p.x-(posicion.x+(ancho/2)));
		int difY=Math.abs(p.y-(posicion.y+(ancho/2)));
		return ( (difX<ancho/2) && (difY<ancho/2));
		
		
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
				gpieza[i].fillOval(this.getX()-5, this.getY()-this.getAncho(), this.getRadio(), this.getRadio());
				gpieza[i].setColor(Color.WHITE);
				gpieza[i].drawString(getNombre1(),this.getX()+5,this.getY()-8);
				
			}
			if(i==1){
				gpieza[i]=g;
				gpieza[i].setColor(Color.RED);
				gpieza[i].fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
				gpieza[i].setColor(Color.WHITE);
				gpieza[i].drawString(getNombre2(),this.getX()+5,(this.getY()+this.getAncho()/2)+5);
			}
		}	
		
		
		if(this.getSeleccionada()){
			
			for(int i=0;i<2;i++){
				if(i==0){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillOval(this.getX()-5, this.getY()-this.getAncho(), this.getRadio(), this.getRadio());
				}
				if(i==1){
					gpieza[i]=g;
					gpieza[i].setColor(Color.lightGray);
					gpieza[i].fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
				}
			}
			
			
		}
		
		
		
	}



	@Override
	public String getNombre1() {
		// TODO Auto-generated method stub
		return programa;
	}


	@Override
	public void setNombre1(String name) {
		// TODO Auto-generated method stub
		this.programa=name;
	}


	@Override
	public String getNombre2() {
		// TODO Auto-generated method stub
		return lenguaje;
	}


	@Override
	public void setNombre2(String name) {
		// TODO Auto-generated method stub
		this.lenguaje=name;
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
