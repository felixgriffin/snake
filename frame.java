package snake;
import java.awt.FlowLayout;  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import java.awt.GridLayout;
import snake.*;

/**
 * Write a description of class frame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class frame extends JFrame
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class frame
     */
    public frame()
    {
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("Snake");
setResizable(false);

init();
    }
    
    public void init() {
     setLayout(new GridLayout(1, 1, 0, 0)); 
     
     Screen s = new Screen();
     add(s);
     
     pack();
     
     setLocationRelativeTo(null);
     setVisible(true);
     
    }
    
}
