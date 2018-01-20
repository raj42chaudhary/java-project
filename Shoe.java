import java.applet.*;
import java.awt.*;
public class Shoe extends Applet
{
	public void paint(Graphics g)
	{
		g.fillRoundRect(20,400,600,40,10,10);
		g.drawRoundRect(20,150,600,250,60,40);	
		g.setColor(Color.white);
		g.fillRect(20,150,599,235);
		g.setColor(Color.black);
		g.drawRoundRect(20,150,600,200,45,10);
		g.setColor(Color.white);
		g.fillRect(20,150,450,20);
		g.setColor(Color.black);
		g.drawRoundRect(450,150,170,200,45,10);
		g.setColor(Color.white);
		g.fillRect(20,160,599,200);
		g.setColor(Color.black);
		g.drawRoundRect(20,130,430,100,60,60);
		g.setColor(Color.white);
		g.fillRect(20,130,430,70);
		g.fillRect(20,130,415,120);
		g.setColor(Color.black);
		g.drawArc(15,320,100,90,140,70);
		g.drawArc(26,319,100,44,120,47);
		g.drawLine(434,226,52,321);
		g.setColor(Color.white);
		int i,j=35;
		for(i=0;i<15;i++)
		{
			g.fillRoundRect(j,433,10,20,10,10);
			j=j+42;
		}
		g.setColor(Color.black);
		int x[]={400,350,355,405};
		int y[]={229,240,260,249};
		int n=x.length;
		g.fillPolygon(x,y,n);
		int a[]={302,252,257,307};
		int b[]={249,260,280,269};
		int c=x.length;
		g.fillPolygon(a,b,c);
	}
}