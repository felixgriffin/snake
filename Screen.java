package snake;
import entities.*;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.util.*;
import java.io.*;
import ecs100.*;

/**
 * Write a description of class Screen here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Screen extends JPanel implements Runnable
{
    // instance variables - replace the example below with your own
    public static final int WIDTH = 800, HEIGHT = 800;
    private Thread thread;
    private boolean running = false; 
    private BodyPart b;
    private ArrayList <BodyPart> snake;

    private int xCoord = 10, yCoord = 10;
    private int size = 5;

    private boolean right = true, left = false, up = false, down = false; 

    private int ticks = 0;

    /**k
     * Constructor for objects of class Screen
     */
    public Screen()
    {
        // initialise instance variables
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        snake = new ArrayList<BodyPart>();

        start();
    }

    public void tick (){
        if (snake.size() == 0){
            b = new BodyPart(xCoord, yCoord, 10);
            snake.add(b);
        }

        ticks ++;

        if (ticks > 250000){
            if (right) xCoord++;
            if (left) xCoord--;
            if (up) yCoord--;
            if (down) yCoord++;

            ticks = 0;
            b = new BodyPart(xCoord, yCoord, 10);
            snake.add(b);
            
            if (snake.size() > size){
             snake.remove(b);   
            }

        }
    }

    public void paint(Graphics g){
        g.clearRect(0, 0, WIDTH, HEIGHT);
        g.setColor(Color.black);
        for (int i = 0; i < WIDTH / 10; i++){
            g.drawLine(i * 10, 0, i * 10, HEIGHT);

        }

        for (int i = 0; i < HEIGHT / 10; i++){
            g.drawLine(0, i * 10, WIDTH, i * 10);   
        }

        for (int i = 0; i < snake.size(); i++){
            snake.get(i).draw(g);   
        }
    }

    public void start(){
        running = true;
        thread = new Thread(this, "Game Loop");
        thread.start();

    }

    public void stop(){

    }

    public void run(){
        while (running){
            tick();   
        }
    }

}
