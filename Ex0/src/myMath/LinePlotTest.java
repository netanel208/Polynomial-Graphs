package myMath;
/**
 * @author Netanel
 * @author Carmel
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;

import de.erichseifert.gral.data.DataSeries;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.plots.points.DefaultPointRenderer2D;
import de.erichseifert.gral.plots.points.PointRenderer;
import de.erichseifert.gral.ui.InteractivePanel;
/**
 * This class create graph and represent polynom in this graph.
 * <p>
 * A class uses the graph representation tool(located in the ReferencedLibraries - gral-core-0.11.jar)
 * The graph shows the polynomial in a particular area [x0,x1], the extreme points and the area above the function and below the X-axis
 */
public class LinePlotTest extends JFrame {
    
	private static final long serialVersionUID = 1L;

	public LinePlotTest(Polynom polynom, double x0, double x1) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);

        
        DataTable data = new DataTable(Double.class, Double.class);//all points
        DataTable extreme = new DataTable(Double.class, Double.class);// all exterem points
        Polynom_able der = polynom.derivative();
        
        for (double x = x0; x <= x1; x+=0.01) {
            double y = polynom.f(x);
            data.add(x, y);
        }
        double Xextreme =0;
        double Yextreme =0;
        for(double x = x0; x < x1; x+=0.01) {
        	try
        	{
        		Xextreme =der.root(x, x+0.01, 0.001);
        		Yextreme =polynom.f(Xextreme);
        		extreme.add(Xextreme,Yextreme);
        		System.out.println("extreme point: ("+Xextreme+" ,"+Yextreme+")");
        	}
        	catch(RuntimeException e)
        	{}
        }
        XYPlot plot = new XYPlot(data,extreme);//Creates a coordinate system that displays several types of points that we put in
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines); // Connects lines between points
        Color color = new Color(0.6400f, 0.3300f, 0.2126f);
        plot.getPointRenderers(data).get(0).setColor(color);//Specify a color for a particular point collection
        plot.getLineRenderers(data).get(0).setColor(color);
        
        //Area
        double eps = 0.01;
        double area = 0;
		double distancePass = 0;
		double Xs = x0;                                        //x_source
		double Xd = Xs + eps;                                  //x_destination
		double deltaX = Math.abs(x1-x0);
		while(distancePass < deltaX)
		{                   
			double midX = (Xd+Xs)/2;                           //midX belongs to [Xs,Xd]
			if(polynom.f(midX)<0 && polynom.f(Xs)<0 && polynom.f(Xd)<0) //if the function under the x-axis continue
			{
				double height = polynom.f(midX);                  //height = f(midX)
				area += height*eps;                            //rectangle area = height*base
			}
			Xs += eps;                          
			Xd += eps;
			distancePass += eps;
		}
        System.out.println("area under x-axis="+Math.abs(area));

        
     

    }

   }