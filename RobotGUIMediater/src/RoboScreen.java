
import javax.swing.*;

public class RoboScreen 
{
	public JFrame fm=new JFrame("Ariya Remot Handle by SmartPhone");;
	
	public void initiate(JLabel lb)
	{
		
		JLabel lb1=new JLabel("I am Smiling");
		JLabel lb2=new JLabel();
		JPanel pn=new JPanel();
		fm.add(lb1);
		ImageIcon bimg = new ImageIcon("C:/Users/jyothi/Desktop/ToJyothi/res/smilies/1.png");
		lb2.setIcon(bimg);
		pn.add(lb2);
		fm.setExtendedState(fm.MAXIMIZED_BOTH);
		fm.setVisible(true);
		
		
	}
	public void closeWindow()
	{
		fm.setDefaultCloseOperation(fm.EXIT_ON_CLOSE);
	}
		
	public static void main(String arg[])
	{
		
		//new RoboScreen().initiate(null);
	}

}
