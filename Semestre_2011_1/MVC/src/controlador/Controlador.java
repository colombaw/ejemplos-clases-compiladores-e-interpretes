package controlador;
/*mejoras*/

/*base y acciones */

import java.awt.Color;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ListIterator;

import vista.Vista;
import modelo.Circulo;
import modelo.Compilador;
import modelo.Cuadrado;
import modelo.Figura;
import modelo.Interprete;
import modelo.Maquina;
import modelo.Modelo;
import modelo.Programa;

public class Controlador {
	
	private Modelo modelo;
	private Vista vista;
	private Figura seleccionada;
	
	
	private int tipo;
	private boolean center;
	private boolean left;
	
	private int tiposeleccionada;
	
	private JButton butacep;
	
	private String nick;
	boolean activa;
	
	public Controlador(Modelo modelo, Vista vista){
		this.modelo=modelo;
		this.vista=vista;
		seleccionada=null;
		tiposeleccionada=0;
		activa=false;
	}
	
	public void setseleccion(int tipo){	
		this.tipo=tipo;
	}
	
	public Figura obtenerFigura(Point posicion){
		ListIterator<Figura> it=modelo.getListado().listIterator();
	    while (it.hasNext()) {
	    	Figura tmp=it.next();
	    		if(tmp.dentroFigura(posicion)){
	    			tmp.setSeleccionada(true);
	    			tiposeleccionada=tmp.GetTipofigura();
	    			
	    			System.out.println("tipo de figura "+tmp.GetTipofigura());
	    			
	    			return tmp;
	    		}
		    }
	    return null;
	}

	public Figura compararFigura(final Point p, int tipo, final Figura actual){
		int i=0;
		
		final JFrame ventana = new JFrame();
		ventana.setTitle(" Unir Figuras ");
		ventana.setBounds(seleccionada.getX(),seleccionada.getY(),220,120);
		ventana.setLayout(null);
		ventana.setResizable(false);
		ventana.getContentPane().setBackground(Color.WHITE);
		
		JLabel pregunta= new JLabel("¿Desea unir las dos figuras?");
		pregunta.setBounds(30,0,200,30);
		ventana.add(pregunta);
		
		JButton butsi = new JButton("Si");
		butsi.setBounds(50,40, 50, 30);
		ventana.add(butsi);
		JButton butno = new JButton("No");
		butno.setBounds(110,40, 50, 30);
		ventana.add(butno);
		
		
		System.out.println("actual"+p.getX());
		ListIterator<Figura> it=modelo.getListado().listIterator();
		
	    while (it.hasNext()) {
	    	i++;
	    	final Figura tmp=it.next();
	    	System.out.println("lista-->"+tmp.getNombre1()+".."+i);
	    	System.out.println("posilist->"+tmp.getX());
	    	System.out.println("tipo->"+tmp.GetTipofigura());
	    		if(tmp.getSeleccionada()==false){
	    			
	    			if(tipo==1){
	    				
	    				System.out.print("Compilador Vs ");
	    				
	    				if(tmp.GetTipofigura()==1){
	    					System.out.println("Compilador");
	    					if((tmp.getX()+80 <= p.getX() &&  p.getX() <= tmp.getX()+120) && (tmp.getY()+40 <= p.getY() && p.getY() <= tmp.getY()+80)){
	    						System.out.println("Unir compiladores en X");	
	    						if(tmp.getNombre3().compareTo(seleccionada.getNombre1())==0 ){
	    							System.out.print("Si ");
	    							ventana.setVisible(true);
	    							
	    							butsi.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									actual.setX(tmp.getX()+80);
	    									actual.setY(tmp.getY()+40);
	    									
	    									vista.repaint();							
	    									ventana.setVisible(false);
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    							
	    							butno.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									ventana.setVisible(false);
	    									vista.repaint();							
	    									
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    							
	    						}
	    					}
	    					
	    					return tmp;	
	    					
	    				}else if(tmp.GetTipofigura()==2){
	    					System.out.print("Programa");
	    					if((tmp.getX()+40 <= p.getX() && p.getX() <= tmp.getX()+80) && (tmp.getY() <= p.getY() && p.getY() <= tmp.getY()+40)){
	    						System.out.println("Unir compilador con Programa");
	    						
	    						if(tmp.getNombre2().compareTo(seleccionada.getNombre1())==0 ){
	    							System.out.print("Si ");
	    							ventana.setVisible(true);
	    							
	    							butsi.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									actual.setX(tmp.getX()+40);
	    									actual.setY(tmp.getY());
	    									
	    									vista.repaint();							
	    									ventana.setVisible(false);
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    							
	    							butno.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									ventana.setVisible(false);
	    									vista.repaint();							
	    									
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    						}
	    						
	    					}
	    					
	    					
	    					return tmp;
	    					
	    					
	    				}else if(tmp.GetTipofigura()==3){
	    					System.out.print("Maquina");
	    					
	    				}else if(tmp.GetTipofigura()==4){
	    					System.out.print("Interprete");
	    				}
	    				
	    			}else if(tipo==2){
	    				
	    				if(tmp.GetTipofigura()==1){
		    				
	    				}else if(tmp.GetTipofigura()==2){
	    					
	    				}else if(tmp.GetTipofigura()==3){
	    					
	    				}else if(tmp.GetTipofigura()==4){
	    					
	    				}
	    				
	    			}else if(tipo==3){
	    				/* maquina se une a compilador */
	    				if(tmp.GetTipofigura()==1){
	    					/********Compilador maquina ********/
	    					if((tmp.getX()+40 <= p.getX() &&  p.getX() <= tmp.getX()+80) && (tmp.getY()+80 <= p.getY() && p.getY() <= tmp.getY()+120)){
	    						System.out.println("Unir compilador maquina");
	    						if(tmp.getNombre3().compareTo(seleccionada.getNombre1())==0 ){
	    							System.out.print("Si ");
	    							ventana.setVisible(true);
	    							
	    							butsi.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									actual.setX(tmp.getX()+40);
	    									actual.setY(tmp.getY()+80);
	    									
	    									vista.repaint();							
	    									ventana.setVisible(false);
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    							
	    							butno.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									ventana.setVisible(false);
	    									vista.repaint();							
	    									
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    							
	    						}
	    					
	    						
	    						
	    						
	    						
	    					}
	    					
	    					/***********************************/

	    				}else if(tmp.GetTipofigura()==2){
	    					
	    				}else if(tmp.GetTipofigura()==3){
	    					
	    				}else if(tmp.GetTipofigura()==4){
	    					/* colocarle una maquina a un interprete */
	    					if((tmp.getX() <= p.getX() &&  p.getX() <= tmp.getX()+40) && (tmp.getY()+80 <= p.getY() && p.getY() <= tmp.getY()+120)){
	    						System.out.println("Unir compilador maquina");
	    						if(tmp.getNombre2().compareTo(seleccionada.getNombre1())==0 ){
	    							System.out.print("Si ");
	    							ventana.setVisible(true);
	    							
	    							butsi.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									actual.setX(tmp.getX());
	    									actual.setY(tmp.getY()+80);
	    									
	    									vista.repaint();							
	    									ventana.setVisible(false);
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    							
	    							butno.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									ventana.setVisible(false);
	    									vista.repaint();							
	    									
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    							
	    						}
	    					
	    						
	    						
	    						
	    						
	    					}
	    					
	    					
	    					
	    				}
	    				
	    			}else if(tipo==4){
	    				
	    				if(tmp.GetTipofigura()==1){
		    			/********************************/	
	    					if((tmp.getX()+40 <= p.getX() &&  p.getX() <= tmp.getX()+80) && (tmp.getY()+80 <= p.getY() && p.getY() <= tmp.getY()+120)){
	    						System.out.println("Unir compilador maquina");
	    						if(tmp.getNombre3().compareTo(seleccionada.getNombre1())==0 ){
	    							System.out.print("Si ");
	    							ventana.setVisible(true);
	    							
	    							butsi.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									actual.setX(tmp.getX()+40);
	    									actual.setY(tmp.getY()+80);
	    									
	    									vista.repaint();							
	    									ventana.setVisible(false);
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    							
	    							butno.addMouseListener(new MouseListener() {
	    								
	    								@Override
	    								public void mouseReleased(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    									ventana.setVisible(false);
	    									vista.repaint();							
	    									
	    								}
	    								

	    								@Override
	    								public void mousePressed(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseExited(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseEntered(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    								
	    								@Override
	    								public void mouseClicked(MouseEvent ar) {
	    									// TODO Auto-generated method stub
	    									
	    								}
	    							});
	    							
	    						}
	    			
	    						
	    					}	
	    					
	    					
	    				/******************************/	
	    				}else if(tmp.GetTipofigura()==2){
	    					
	    				}else if(tmp.GetTipofigura()==3){
	    					
	    				}else if(tmp.GetTipofigura()==4){
	    					
	    				}
	    				
	    			}
	    			
	    			
	    			
	    			
	    			
	    			
	    			/*if(p.getX() < tmp.getX()-10 || p.getY() < tmp.getY()+10){
	    				//elemento.seleccionada=true;
	    				//elemento.dentroFigura(p)
	    				//System.out.println("--"+elemento.getNombre1());nombre de la seleccionada

	    				//acciones internas 

	    				System.out.println("serca");
	    				return tmp;				
	    			}*/
	    			
	    		}
		    }
		
		
		return null;
	}
	
	
	public void cambiarPosicion(Figura f, Point p){
		f.setPosicion(p);
	}
	
	public Vista getVista(){
		return vista;
	}
	
	public void anyadirFigura(Figura f){
		modelo.anyadirFigura(f);
	}
	
	public Figura getFiguraEn(Point p){
		
		return modelo.getFiguraEn(p);
	}
	/*creado para conseguir el string de la figura*/
	final void setFiguraEn(Point p,String n1,int indi){
		 modelo.setFiguraEn(p,n1,indi);
	}
	
	
	
	public void eVmousePressed(MouseEvent ev) {
		/*tipo de elemento a añadir*/
		/*
		if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			seleccionada=this.getFiguraEn(ev.getPoint());
		}else if(SwingUtilities.isRightMouseButton(ev)){		//click boton izquierdo añade figura tipo cuadrado
			this.anyadirFigura(new Cuadrado(ev.getPoint(),25));			
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio añade figura tipo circulo
		{
			this.anyadirFigura(new Circulo(ev.getPoint(),25));// lo grande de la figura
		}*/

		
		/* Por tipo de figura */
		if(SwingUtilities.isLeftMouseButton(ev)){ 			//Click boton izquierdo selecciona figura
			left=true;
			seleccionada=this.getFiguraEn(ev.getPoint());
			
			
		}else if(tipo == 1 && SwingUtilities.isRightMouseButton(ev)){
			this.anyadirFigura(new Compilador(ev.getPoint(),40));
		}
		else if(tipo == 2 && SwingUtilities.isRightMouseButton(ev)){
			this.anyadirFigura(new Programa(ev.getPoint(),40));
		}
		else if(tipo == 3 && SwingUtilities.isRightMouseButton(ev)){
			this.anyadirFigura(new Maquina(ev.getPoint(),40));
			
		}else if(tipo == 4 && SwingUtilities.isRightMouseButton(ev)){
			this.anyadirFigura(new Interprete(ev.getPoint(),40));
			
		}else if(SwingUtilities.isMiddleMouseButton(ev))//click boton medio añade figura tipo circulo
		{
			
			//this.anyadirFigura(new Circulo(ev.getPoint(),25));// lo grande de la figura
			seleccionada=this.getFiguraEn(ev.getPoint());   
			this.obtenerFigura(ev.getPoint());
			center=true;
			left=false;
	
		}
		vista.repaint();		
	}
	
	public void eVmouseDragged(MouseEvent ev) {
		if(seleccionada!=null){
			//El a figura esta seleccionada
			
			this.cambiarPosicion(seleccionada, ev.getPoint());
			vista.repaint();
		}
	}
	
	
	public void eVmouseClicked(MouseEvent ev) {
		//if(seleccionada!=null){
			//El a figura esta seleccionada
			//this.cambiarPosicion(seleccionada, ev.getPoint());
			
			/////////////////////////////////////////
			vista.repaint();
		//}
	}

	public void eVmouseReleased (MouseEvent ev) {
		
		if(seleccionada!=null){
		/*menu segun la pieza*/	
		/* saber el tipo de figura que tiene en el momento */
			/*  fuente       objeto  */
			/*     implementacion    */
			final Figura magic;
			final boolean operation=false;// si hizo click interno
			
			if(center==true){
				final MouseEvent extra=ev;
				if(tiposeleccionada==1){
					
					
					final JFrame frame1 = new JFrame();
					frame1.setTitle(" Datos del Compilador ");
					frame1.setBounds(seleccionada.getX(),seleccionada.getY(),260,160);
					JPanel p1 = new JPanel();
					p1.setLayout(null);
					p1.setBounds(0,0,260,160);
					p1.setBackground(Color.lightGray);
					/*Etiqueta*/
					JLabel lfuente= new JLabel("Fuente:");
					lfuente.setBounds(65,0,50,30);
					p1.add(lfuente);
					JLabel limp= new JLabel("Implementacion:");
					limp.setBounds(10,30,100,30);
					p1.add(limp);
					JLabel lobj= new JLabel("Objeto:");
					lobj.setBounds(65,60,100,30);
					p1.add(lobj);
					
					/*Textfield*/
					final JTextField tfuente = new JTextField();
					tfuente.setBounds(116,2,120,25);
					p1.add(tfuente);
					final JTextField tobj = new JTextField();
					tobj.setBounds(116,60,120,25);
					p1.add(tobj);
					final JTextField timple = new JTextField();
					timple.setBounds(116,30,120,25);
					p1.add(timple);
					
					
					/*botones*/
					butacep = new JButton("Aceptar");
					butacep.setBounds(20,95, 100, 30);
					p1.add(butacep);
					JButton butelim = new JButton("Eliminar");
					butelim.setBounds(130,95, 100, 30);
					p1.add(butelim);
					activa=false;
					
					butacep.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent ar) {
							// TODO Auto-generated method stub
							//seleccionada=this.getFiguraEn(ev.getPoint());
							//seleccionada=t;
							//this.
							/*  fuente       objeto  */
							/*     implementacion    */
							
							if(tfuente.getText().isEmpty() || tobj.getText().isEmpty() || timple.getText().isEmpty()){
								JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error",JOptionPane.WARNING_MESSAGE);
								tfuente.setText("");
								tobj.setText("");
								timple.setText("");
							}else{
								/*nombre 1*/
								setFiguraEn(extra.getPoint(),tfuente.getText(),1);
								/*nombre 2*/
								setFiguraEn(extra.getPoint(),tobj.getText(),2);
								/*nombre 3*/
								setFiguraEn(extra.getPoint(),timple.getText(),3);
								seleccionada.setSeleccionada(false);
								seleccionada=null;
								frame1.setVisible(false);
							}
							vista.repaint();
						}
						

						@Override
						public void mousePressed(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
					});
					
					butelim.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent ar) {
							// TODO Auto-generated method stub
							modelo.eliminarFigura(seleccionada);
							seleccionada.setSeleccionada(false);
							seleccionada=null;
							frame1.setVisible(false);
							vista.repaint();							
							
						}
						

						@Override
						public void mousePressed(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
					});
																
					frame1.add(p1);
					frame1.setResizable(false);
					frame1.setVisible(true);
					center=false;
				
				}else if(tiposeleccionada==2){
					
					final JFrame frame2 = new JFrame();
					frame2.setTitle(" Datos del Programa ");
					frame2.setBounds(seleccionada.getX(),seleccionada.getY(),250,135);
					JPanel p2 = new JPanel();
					p2.setLayout(null);
					p2.setBounds(0,0,250,135);
					p2.setBackground(Color.lightGray);
					
					/*Etiquetas*/
					JLabel lprograma= new JLabel("Programa:");
					lprograma.setBounds(20,0,80,30);
					p2.add(lprograma);
					JLabel llenguaje= new JLabel("Lenguaje:");
					llenguaje.setBounds(25,30,60,30);
					p2.add(llenguaje);
					
					/*Textfield*/
					final JTextField tprograma = new JTextField();
					tprograma.setBounds(100,2,120,25);
					p2.add(tprograma);
					final JTextField tlenguaje = new JTextField();
					tlenguaje.setBounds(100,30,120,25);
					p2.add(tlenguaje);
					
					/*botones*/					
					JButton butacep2 = new JButton("Aceptar");
					butacep2.setBounds(16,70, 100, 30);
					p2.add(butacep2);
					JButton butelim2 = new JButton("Eliminar");
					butelim2.setBounds(126,70, 100, 30);
					p2.add(butelim2);

					butacep2.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent ar) {
							// TODO Auto-generated method stub
							//seleccionada=this.getFiguraEn(ev.getPoint());
							//seleccionada=t;
							
							/*  Programa  */
							
							if(tprograma.getText().isEmpty() || tlenguaje.getText().isEmpty()){
								JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error",JOptionPane.WARNING_MESSAGE);
								tprograma.setText("");
								tlenguaje.setText("");
							}else{
								/*nombre 1*/
								setFiguraEn(extra.getPoint(),tprograma.getText(),1);
								/*nombre 2*/
								setFiguraEn(extra.getPoint(),tlenguaje.getText(),2);
								
								seleccionada.setSeleccionada(false);
								seleccionada=null;
								frame2.setVisible(false);
							}
							
							vista.repaint();
							
						}
						

						@Override
						public void mousePressed(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
					});
					
					butelim2.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent ar) {
							// TODO Auto-generated method stub
							modelo.eliminarFigura(seleccionada);
							seleccionada.setSeleccionada(false);
							seleccionada=null;
							frame2.setVisible(false);
							vista.repaint();
							
						}
						

						@Override
						public void mousePressed(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
					});
					
					frame2.add(p2);
					frame2.setResizable(false);
					frame2.setVisible(true);
					center=false;
					
				}else if(tiposeleccionada==3){
					
					final JFrame frame3 = new JFrame();
					frame3.setTitle(" Datos de la Maquina ");
					frame3.setBounds(seleccionada.getX(),seleccionada.getY(),260,110);
					JPanel p3 = new JPanel();
					p3.setLayout(null);
					p3.setBounds(0,0,260,110);
					p3.setBackground(Color.lightGray);
					
					/*Etiquetas*/
					JLabel lplataforma= new JLabel("Plataforma:");
					lplataforma.setBounds(27,0,80,30);
					p3.add(lplataforma);
					
					/*Textfield*/
					final JTextField tplataforma = new JTextField();
					tplataforma.setBounds(107,2,120,25);
					p3.add(tplataforma);
					
					/*botones*/		
					JButton butacep3 = new JButton("Aceptar");
					butacep3.setBounds(21,40, 100, 30);
					p3.add(butacep3);
					JButton butelim3 = new JButton("Eliminar");
					butelim3.setBounds(131,40, 100, 30);
					p3.add(butelim3);
					
					butacep3.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent ar) {
							// TODO Auto-generated method stub
							//seleccionada=this.getFiguraEn(ev.getPoint());
							//seleccionada=t;
							//this.
							/*  plataforma */
							
							if(tplataforma.getText().isEmpty()){
								JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error",JOptionPane.WARNING_MESSAGE);
								tplataforma.setText("");
							}else{
								/*nombre 1*/
								setFiguraEn(extra.getPoint(),tplataforma.getText(),1);
								
								seleccionada.setSeleccionada(false);
								seleccionada=null;
								frame3.setVisible(false);
							}
							
							vista.repaint();
							
						}
						
						@Override
						public void mousePressed(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
					});
					
					
					butelim3.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent ar) {
							// TODO Auto-generated method stub
							modelo.eliminarFigura(seleccionada);
							seleccionada.setSeleccionada(false);
							seleccionada=null;
							frame3.setVisible(false);
							vista.repaint();
						}
						

						@Override
						public void mousePressed(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
					});
					
					
					frame3.add(p3);
					frame3.setResizable(false);
					frame3.setVisible(true);
					center=false;
					
				}else if(tiposeleccionada==4){
					
					final JFrame frame4 = new JFrame();
					frame4.setTitle(" Datos del Interprete ");
					frame4.setBounds(seleccionada.getX(),seleccionada.getY(),250,135);
					JPanel p4 = new JPanel();
					p4.setLayout(null);
					p4.setBounds(0,0,250,135);
					p4.setBackground(Color.lightGray);
					
					/*Etiquetas*/
					JLabel llengua = new JLabel("Lenguaje:");
					llengua.setBounds(20,0,80,30);
					p4.add(llengua);
					JLabel lescrito= new JLabel("Escrito en:");
					lescrito.setBounds(15,30,60,30);
					p4.add(lescrito);
					
					/*Textfield*/
					final JTextField tlengua = new JTextField();
					tlengua.setBounds(100,2,120,25);
					p4.add(tlengua);
					final JTextField tescrito = new JTextField();
					tescrito.setBounds(100,30,120,25);
					p4.add(tescrito);
					
					/*botones*/					
					JButton butacep4 = new JButton("Aceptar");
					butacep4.setBounds(16,70, 100, 30);
					p4.add(butacep4);
					JButton butelim4 = new JButton("Eliminar");
					butelim4.setBounds(126,70, 100, 30);
					p4.add(butelim4);

					
					butacep4.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent ar) {
							// TODO Auto-generated method stub
							//seleccionada=this.getFiguraEn(ev.getPoint());
							//seleccionada=t;
							//this.
							/* Interprete */
							
							if(tlengua.getText().isEmpty() || tescrito.getText().isEmpty()){
								JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error",JOptionPane.WARNING_MESSAGE);
								tlengua.setText("");
								tescrito.setText("");
							}else{
								/*nombre 1*/
								setFiguraEn(extra.getPoint(),tlengua.getText(),1);
								/*nombre 2*/
								setFiguraEn(extra.getPoint(),tescrito.getText(),2);
								
								seleccionada.setSeleccionada(false);
								seleccionada=null;
								frame4.setVisible(false);
							}
							
							vista.repaint();
						}
						

						@Override
						public void mousePressed(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
					});
					
					
					butelim4.addMouseListener(new MouseListener() {
						
						@Override
						public void mouseReleased(MouseEvent ar) {
							// TODO Auto-generated method stub
							modelo.eliminarFigura(seleccionada);
							seleccionada.setSeleccionada(false);
							seleccionada=null;
							frame4.setVisible(false);
							vista.repaint();
							
						}
						

						@Override
						public void mousePressed(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseExited(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseEntered(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void mouseClicked(MouseEvent ar) {
							// TODO Auto-generated method stub
							
						}
					});
					
					
					frame4.add(p4);
					frame4.setResizable(false);
					frame4.setVisible(true);
					center=false;
				}
				
			}
			
			
			
			if(left==true){
				
			this.compararFigura(ev.getPoint(),tipo, seleccionada);
			seleccionada.setSeleccionada(false);
			seleccionada=null;
			}
			
		}
		vista.repaint();
	}

	
	
	
}
