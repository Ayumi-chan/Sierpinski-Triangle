import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.geom.Line2D;


import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class SierpinskiTriangle extends JFrame {


/**
 * 
 */
private static final long serialVersionUID = 1L;
private long iteration;
private Pair<int[], int[]> polygon_points;
public Fractal(Pair<int[], int[]> polygon_points, long iteration)
{
this.polygon_points = polygon_points;
this.iteration = iteration;


this.setSize(500, 460);
this.setTitle("Fractal");
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


this.setVisible(true);
}


public void paint(Graphics g) 
{
int i = -1;
        paint((Graphics2D)g, iteration, 
        		new Point(polygon_points.first[++i], polygon_points.second[i]), 
        		new Point(polygon_points.first[++i], polygon_points.second[i]),
        		new Point(polygon_points.first[++i], polygon_points.second[i]));  
    }


private static Polygon pointsToPolygon(Point p1, Point p2, Point p3)
{
Polygon p = new Polygon();
    	p.addPoint(p1.x, p1.y);
    	p.addPoint(p2.x, p2.y);
    	p.addPoint(p3.x, p3.y);
    	return p;
}


public void paint(Graphics2D g2, long i, Point p1, Point p2, Point p3)
{
if (i > 1)
        {
Point pp1 = new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
Point pp2 = new Point((p3.x + p2.x) / 2, (p3.y + p2.y) / 2);
Point pp3 = new Point((p1.x + p3.x) / 2, (p1.y + p3.y) / 2);




paint(g2, i - 1, p1, pp1, pp3);
paint(g2, i - 1, pp1, p2, pp2);
paint(g2, i - 1, pp3, pp2, p3);




        }
        else 
        {
        	g2.fillPolygon(pointsToPolygon(p1, p2, p3));
        }
}




public static void main(String[] args)
{
new Fractal(new Pair<int[], int[]>(new int[]{ 250, 400, 100 }, new int[]{ 100, 400, 400}), Integer.parseInt(JOptionPane.showInputDialog(null, "# of iterations?")));
}




}



}