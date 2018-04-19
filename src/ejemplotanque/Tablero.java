/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejemplotanque;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Estudiante
 * Jpanel dado que voy a pintar en el Canvas
 * ActionListener: Para poder ejecutar el escenario cada ciertos milisegundos
 */
public class Tablero extends JPanel implements ActionListener{
    private Timer timer ;
    private int x;
    private int y;
    private int secuencia;
    public Tablero(){
        //Lanza un evento de tipo ActionListener cada 25 Milisegundo
        //Se hace referencia a this porque la misma clase (Tablero) procesa el evento
        this.timer = new Timer(25, this);
        this.x=0;
        this.y=0;
        //Registrar evento del Teclado
        setFocusable(true); //Debe estar en modo Focus para que puede detectar el evento
        addKeyListener(new EventosTeclado()); //Inner class que procesa los eventos del teclado
        this.timer.start(); //Inicio con el escenario
    }
        
    //Inner class Que captura los eventos del teclado
     private class EventosTeclado extends KeyAdapter {
        //Cuando se suelta una tecla
         @Override
        public void keyReleased(KeyEvent e) {
           int key = e.getKeyCode();
           if (key == KeyEvent.VK_SPACE) {
            System.out.println("VK_SPACE"); //Se  va usar posteriormente 
           }
        }
        //Cuando se presiona una tecla
        @Override
        public void keyPressed(KeyEvent e) {
           
        }
    }
    
    //Metodo donde se pintan los objetos 
     @Override
    public void paintComponent(Graphics g){
       super.paintComponent(g);
       g.fillRect(this.x,this.y, 20, 20);
       Image fondo = this.loadImage("fondo.png");
       //g.drawImage(fondo,0,0,this);
       //1024*512
       g.drawImage(fondo, this.x*-1,0, (this.x*-1)+1024,512, 0, 0, 1024,512, this);
       
       
       
       Image tanque = this.loadImage("1.png");
       //g.drawImage(tanque, this.x, 200, this);
       g.drawImage(tanque, 30, 200, this);
       g.drawRect(30, 30, 20, 20);
       
         if (this.secuencia==5) {
             this.secuencia=0;                     
         } else {
             this.secuencia++;
         }
       
       Image cat = this.loadImage("cats.gif");
       //g.drawImage(cat, this.x, this.y, this);
       
       
       //g.drawImage(cat, dx1,dy1, dx2,dy2, sx1, sy1 , sx2 ,sy2, this)
//       g.drawImage(cat, 30,30, 162,110, 0, 0 , 132 ,80, this);
//       g.drawImage(cat, 30,30, 294,110, 0, 0 , 264 ,80, this);
//       g.drawImage(cat, 30,30, 426,110, 0, 0 , 396 ,80, this);
//       g.drawImage(cat, 30,30, 558,110, 0, 0 , 528,80, this);
//       g.drawImage(cat, 30,30, 690,110, 0, 0 , 660,80, this);
//       g.drawImage(cat, 30,30, 822,110, 0, 0 , 792,80, this);
       
        //g.drawImage(cat, this.x,200, this.x +132,280, 132*this.secuencia, 0 , (this.secuencia*132)+132,80, this);
        g.drawImage(cat, 30,200, 162,280, 132*this.secuencia, 0 , (this.secuencia*132)+132,80, this);
       
    }

    //Metodo que se ejecuta cada vez que se lanza un ActionListener
    
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println("Repaint");
        this.x++;
        repaint();
    }
    
    //Opengameart.org
    
    public Image loadImage(String imageName){
        ImageIcon ii = new ImageIcon(imageName);
        Image image = ii.getImage();
        return image;
    }
}
