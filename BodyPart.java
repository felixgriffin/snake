package entities;
import java.awt.*;
import java.util.*;
import java.io.*;
import ecs100.*;

/**
 * Write a description of class BodyPart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BodyPart
{
    // instance variables - replace the example below with your own
    private int xCoord, yCoord, width, height;
    
    

    /**
     * Constructor for objects of class BodyPart
     */
    public BodyPart(int xCord, int yCord, int tileSize)
    {
        // initialise instance variables
       this.xCoord = xCord;
       this.yCoord = yCord;
       width = tileSize;
       height = tileSize;
    }

    public void tick () {
        
    }
    
    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect(xCoord * width, yCoord * height, width, height);
        g.setColor(Color.green);
        g.fillRect(xCoord * width + 2, yCoord * height + 2, width - 4, height - 4);
    }
    
}
