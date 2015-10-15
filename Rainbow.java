// Chapter 5 Question 27

// ________________________________________________
package rainbow;
//By Chris Bradsher

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rainbow extends JPanel
{
  // Declare skyColor:
  // _______________________________________________
	Color skyColor = Color.CYAN;

  public Rainbow()
  {
    setBackground(skyColor);
  }

  // Draws the rainbow.
  public void paintComponent(Graphics g)
  {
    super.paintComponent(g);
    int width = getWidth(), height = getHeight(), xCenter=width/2, yCenter=(3*height)/4; //yCenter is never used but they say to declare it so I did
    final int botGap=height/10; //This is used to make everything a bit above the bottom of the screen like their example picture shows
    int w=5,h=3;

    // Declare and initialize local int variables xCenter, yCenter
    // that represent the center of the rainbow rings:
    //   ^ done in the bulk initialization
    // Declare and initialize the radius of the large semicircle:
    int largeRadius=width/4;

    g.setColor(Color.RED);

    // Draw the large semicircle:
    // g.fillArc( ______________ );
    g.fillArc(xCenter-largeRadius, height-largeRadius-botGap, 2*largeRadius, 2*largeRadius, 0, 180);

    // Declare and initialize the radii of the small and medium
    // semicircles and draw them:
    // ________________________________________________
    int smallRadius=height/4; //per their instructions
    int mediumRadius=(int)Math.sqrt(smallRadius*largeRadius); //per their instructions
    g.setColor(Color.GREEN); 
    g.fillArc(xCenter-mediumRadius, height-mediumRadius-botGap, 2*mediumRadius, 2*mediumRadius, 0, 180);
    g.setColor(Color.MAGENTA);
    g.fillArc(xCenter-smallRadius, height-smallRadius-botGap, 2*smallRadius, 2*smallRadius, 0, 180);
    // Calculate the radius of the innermost (sky-color) semicircle
    // so that the width of the middle (green) ring is the
    // arithmetic mean of the widths of the red and magenta rings:
    // ________________________________________________
    /*Algebraic steps to a one-line solution:
       (redWidth+magentaWidth)/2=greenWidth     //equation
       ((largeRadius-mediumRadius)+(smallRadius-miniRadius))/2=(mediumRadius-smallRadius)    //convert to the variables we're using and solve for miniRadius
       (largeRadius-mediumRadius)+(smallRadius-miniRadius)=2*(mediumRadius-smallRadius)
       (smallRadius-miniRadius)=2*(mediumRadius-smallRadius)-largeRadius+mediumRadius
       miniRadius=-2*(mediumRadius-smallRadius)-largeRadius+mediumRadius-smallRadius
       miniRadius=-(3*mediumRadius-3*smallRadius-largeRadius)
     */
    int miniRadius=-(3*mediumRadius-3*smallRadius-largeRadius);

    // Draw the sky-color semicircle:
    // ________________________________________________
    g.setColor(skyColor);
    g.fillArc(xCenter-miniRadius, height-miniRadius-botGap, 2*miniRadius, 2*miniRadius, 0, 180);
    
    
    /*
     * Let it be noted that using
     * largeRadius=width/4;
     * smallRadius=largeRadius/2;
     * miniRadius=largeRadius/4;
     * mediumRadius=3*miniRadius;
     * creates a far better looking semicircle than this geometric-algebraic means method.
     */
    
  }

  public static void main(String[] args)
  {
    JFrame w = new JFrame("Rainbow");
    w.setBounds(300, 300, 300, 200);
    w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container c = w.getContentPane();
    c.add(new Rainbow());
    w.setVisible(true);
  }
}
