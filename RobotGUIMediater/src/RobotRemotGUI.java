import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.*;




public class RobotRemotGUI {

	JFrame fm;
	JPanel pn;
	JButton b1,b2,b3,b4;
	

	public RobotRemotGUI() {
		 Runtime runtime=Runtime.getRuntime();
		fm =new JFrame("Controlled by Smartphone only");
		pn=new JPanel();
		b1=new JButton();
		
		b2=new JButton();
		
		b3=new JButton();
		
		b4=new JButton();
		
		GridLayout gl=new GridLayout(2,2,10,10);
		pn.setLayout(gl);
		
		
		fm.add(pn);
		pn.add(b1);
		pn.add(b2);
		pn.add(b3);
		pn.add(b4);
		b1.setSelected(false);
		fm.setSize(313,313);
		Dimension dm=Toolkit.getDefaultToolkit().getScreenSize();
		fm.setLocation(dm.width/2-fm.getSize().width/2,dm.height/2-fm.getSize().height/2);
		
		fm.setVisible(true);
		fm.setDefaultCloseOperation(fm.EXIT_ON_CLOSE);
		
	}
	public static void main(String arg[])
	{
		new RobotRemotGUI().setImage(4);
		
		
	}
	public void closeWindow()
	{
		fm.setDefaultCloseOperation(fm.EXIT_ON_CLOSE);
	}
	
	public void setImage(int a)
	{
		if(a==1)
		{
			setNull();
			ImageIcon bimg1 = new ImageIcon("C:/Users/jyothi/Desktop/ToJyothi/res/smilies/1.png");
			b1.setIcon(bimg1);
			try{Runtime.getRuntime().exec("cvlc /home/udooer/Desktop/lady/thanku.wav");}catch(Exception e){System.out.println(e.toString());}	
		}
		if(a==2)
		{
			setNull();
			ImageIcon bimg2 = new ImageIcon("C:/Users/jyothi/Desktop/ToJyothi/res/smilies/2.png");
			b2.setIcon(bimg2);
			try{Runtime.getRuntime().exec("cvlc /home/udooer/Desktop/lady/thanku.wav");}catch(Exception e){System.out.println(e.toString());}	
		}
		if(a==3)
		{
			setNull();
			ImageIcon bimg3 = new ImageIcon("C:/Users/jyothi/Desktop/ToJyothi/res/smilies/3.png");
			b3.setIcon(bimg3);
			try{Runtime.getRuntime().exec("cvlc /home/udooer/Desktop/lady/thanku.wav");}catch(Exception e){System.out.println(e.toString());}	
		}
		if(a==4)
		{
			setNull();
			ImageIcon bimg4 = new ImageIcon("C:/Users/jyothi/Desktop/ToJyothi/res/smilies/4.png");
			b4.setIcon(bimg4);
			try{Runtime.getRuntime().exec("cvlc /home/udooer/Desktop/lady/thanku.wav");}catch(Exception e){System.out.println(e.toString());}	
		}
	}
	public void setNull()
	{
		ImageIcon bimg1 = new ImageIcon("C:/Users/jyothi/Desktop/ToJyothi/res/smilies/a1.png");
		b1.setIcon(bimg1);
		ImageIcon bimg2 = new ImageIcon("C:/Users/jyothi/Desktop/ToJyothi/res/smilies/a2.png");
		b2.setIcon(bimg2);
		ImageIcon bimg3 = new ImageIcon("C:/Users/jyothi/Desktop/ToJyothi/res/smilies/a3.png");
		b3.setIcon(bimg3);
		ImageIcon bimg4 = new ImageIcon("C:/Users/jyothi/Desktop/ToJyothi/res/smilies/a4.png");
		b4.setIcon(bimg4);
	
	}

}
