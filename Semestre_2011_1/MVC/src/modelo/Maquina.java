package modelo;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Maquina extends Figura {

	private int ancho;
	private String plataforma;
	
	public Maquina(Point posicion, int ancho){
		this.posicion=posicion;
		this.ancho=ancho;
		this.seleccionada=false; 
		this.tipofigura=3;
		this.plataforma = "Plat";
	}
	
	public void setAncho(int ancho){
		this.ancho=ancho;
	}
	public int getAncho(){
		return ancho;
	}
	
	public void setPlataforma(String pro){
		this.plataforma=pro;
	}
	public String getPlataforma(){
		return plataforma;
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
				
				gpieza[i].setColor(Color.BLUE);
				gpieza[i].fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
				gpieza[i].setColor(Color.WHITE);
				gpieza[i].drawString(getNombre1(),this.getX()+5,(this.getY()+this.getAncho()/2)+5);
				/// pasar el texto de las las pantallas 
				// dependiendo de el tamaño acomodar las letras
				//
				
			}
			if(i==1){				
				//colocar icono en la parte de abajo :)
				gpieza[i]=g;
				//g2d.draw(this.getX(), this.getY(), this.getAncho(), this.getAncho() );
				//gpieza[i].setColor(Color.gray);
				//gpieza[i].fillRect(this.getX(), this.getY()+this.getAncho(), this.getAncho(), this.getAncho());
				//gpieza[i].setColor(Color.GREEN);
			
			}
		}
		
		if(this.seleccionada){
			for(int i=0;i<2;i++){
				if(i==0){
					gpieza[i]=g;
					
					gpieza[i].setColor(Color.gray);
					gpieza[i].fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
					//gpieza[i].setColor(Color.WHITE);
					//gpieza[i].drawString(getNombre1(),this.getX()+5,(this.getY()+this.getAncho()/2)+5);
					/// pasar el texto de las las pantallas 
					// dependiendo de el tamaño acomodar las letras
					//
					
				}
				if(i==1){				
					//colocar icono en la parte de abajo :)
					gpieza[i]=g;
					
					//gpieza[i].setColor(Color.gray);
					//gpieza[i].fillRect(this.getX(), this.getY(), this.getAncho(), this.getAncho());
					//gpieza[i].setColor(Color.GREEN);
				
				}
			}
			
		}
		
		
		
	}

	@Override
	public String getNombre1() {
		// TODO Auto-generated method stub
		return plataforma;
	}

	@Override
	public void setNombre1(String name) {
		// TODO Auto-generated method stub
		this.plataforma = name;
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
