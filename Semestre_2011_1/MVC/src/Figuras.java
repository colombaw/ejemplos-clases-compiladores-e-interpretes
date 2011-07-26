import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import vista.Vista;
import modelo.Modelo;

import controlador.Controlador;



public class Figuras {
	
	public static void main(String[] args) {
		try{
			final JFrame frame = new JFrame();
			frame.setTitle("Diagramas de Tombstone VGC ");
			//Set the window initial Size & default close operation
			frame.setVisible(true);
			Dimension fullscreen = Toolkit.getDefaultToolkit().getScreenSize();
			fullscreen.width=fullscreen.width-100;
			fullscreen.height=fullscreen.height-250;
			frame.setBounds(50,50,fullscreen.width,fullscreen.height);
			frame.getContentPane().setPreferredSize(fullscreen);
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		    Container guiobjects = frame.getContentPane();
		    guiobjects.setLayout(new BorderLayout());
			Modelo modelo = new Modelo();
			Vista vista = new Vista(new Dimension(1024,768),modelo);
			final Controlador controlador = new Controlador(modelo,vista);
			vista.controlador=controlador; //Lo registro para su uso, deberia ser un metodo pero por simplificacion
			//JScrollPane ModelScroll = new JScrollPane(controlador.getVista(), ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			//guiobjects.add(ModelScroll);				
			/*ModelScroll.repaint();
			frame.repaint();*/
			/*modificacion para que sea un panel estatico*/
			JPanel areadibujo = new JPanel();
			areadibujo.setBounds(150,0,900,750);
			areadibujo.add(controlador.getVista());
			
			/*panel lateral izquierdo sub menu*/
			JPanel areabotones = new JPanel();
			areabotones.setBounds(0,0,0,0);
			areabotones.setLayout(null);
			//areabotones.setLayout(null);
			areabotones.setBackground(Color.LIGHT_GRAY);
			// Etiqueta 
			JLabel agre = new JLabel("Agregar:");
			agre.setBounds(10,0,50,30);
			areabotones.add(agre);
			
			// botones 
			JButton butcompi = new JButton("Compilador");
			butcompi.setBounds(30,30, 100, 30);
			areabotones.add(butcompi);
			//areabotones.add(); botones
			//frame.add(areadibujo);
			//frame.add(areabotones);
			// Boton para crear una figura de tipo compilador
			
			butcompi.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					/**/
					//System.out.println("tipo 1");
					/*Crear un compilador*/
					controlador.setseleccion(1);
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			JButton butpro = new JButton("Programas");
			butpro.setBounds(30,70, 100, 30);
			areabotones.add(butpro);
			butpro.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					/**/
					//System.out.println("tipo 2");
					/*Crear un compilador*/
					controlador.setseleccion(2);
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			JButton butmaqui = new JButton("Maquina");
			butmaqui.setBounds(30,110, 100, 30);
			areabotones.add(butmaqui);
			butmaqui.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					/**/
					//System.out.println("tipo 3");
					/*Crear un compilador*/
					controlador.setseleccion(3);
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			JButton butinter = new JButton("Interprete");
			butinter.setBounds(30,150, 100, 30);
			areabotones.add(butinter);
			
			butinter.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					/**/
					//System.out.println("tipo 3");
					/*Crear un compilador*/
					controlador.setseleccion(4);
				}
				
				@Override
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
			});
			
			guiobjects.add(areadibujo);
			guiobjects.add(areabotones);
			/*-----------------------------------------------------*/
			frame.pack();
		}catch (RuntimeException e){
			exitApplication();
		}

	}


	public static void exitApplication() {
		   System.out.println("Saliendo Adios...");
		   System.exit(0);
        }

}
