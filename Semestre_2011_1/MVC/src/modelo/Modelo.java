package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Modelo {
	
	private List<Figura> listaFiguras;
	
	public Modelo(){
		listaFiguras = new ArrayList<Figura>();
		
	}
	
	public void AnyadirFigura(Figura f){
		listaFiguras.add(f);
		
	}
	
	public void eliminarFigura(Figura f){
		listaFiguras.remove(f);
		
	}
	
	
	public List<Figura> getListado(){
		return listaFiguras;
	}
	
	public void anyadirFigura(Figura f){
		listaFiguras.add(f);
	}
	/* tiene la figura clave */
	public Figura getFiguraEn(Point p){
		for (Figura elemento : getListado()) {
			if(elemento.dentroFigura(p)){
				elemento.seleccionada=true;
			
				//System.out.println("--"+elemento.getNombre1());nombre de la seleccionada
				
				return elemento;				
			}
		}
		return null;
	}
	
	
	
	/* metodo clave para guardar la informacion*/
	/// indice indica a que variable 
	
	public void setFiguraEn(Point p,String name1,int indice){
		for (Figura elemento : getListado()) {
			if(elemento.dentroFigura(p)){
				elemento.seleccionada=true;
				if(indice==1){
				elemento.setNombre1(name1);// agregando nombre 1
				}
				if(indice==2){
				elemento.setNombre2(name1);// agregando nombre 2
				}
				if(indice==3){
					elemento.setNombre3(name1);// agregando nombre 3
				}
				
				//System.out.println(""+elemento.nombre1());
				
								
			}
		}
		
	}
	
	
}
