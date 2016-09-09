

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.*;

import javax.management.RuntimeErrorException;
import javax.microedition.io.StreamConnection;

public class ProcessConnectionThread implements Runnable {

    private StreamConnection mConnection;
    String text="";
    // Constant that indicate command from devices
    private static final int EXIT_CMD = -1;
    private static final int KEY_RIGHT = 1;
    private static final int KEY_LEFT = 2;
    
    public ProcessConnectionThread(StreamConnection connection)
    {
        mConnection = connection;
        
    }

   
    public void run() {
    	
    	try {
    		//RoboScreen rb=new RoboScreen();
    		//frame1 fm=new frame1();	
    		//JLabel lb1=new JLabel("I am Ready");
    		//rb.initiate(lb1);
    		 RobotRemotGUI ar=new RobotRemotGUI();
    		 ar.setNull();
;    		char[] ch=new char[100];
            // prepare to receive data
            InputStream inputStream = mConnection.openInputStream();
            //DataInputStream dis = new DataInputStream(mConnection.openInputStream());

            System.out.println("waiting for input");
             text="";
            while (true) {
            	byte b[]=null;
              int command = inputStream.read();
              ch=Character.toChars(command);
              Runtime runtime=Runtime.getRuntime();
             
              if(ch[0]=='1')
              {
            	 // ar.fm.setVisible(false);
            	//  ar.closeWindow();
            	// ar=new AriyaRemot(1);
            	  //System.out.println("1");
            	  ar.setImage(1);
            	  
             }
             else if(ch[0]=='2')
             {
//            	 ar.fm.setVisible(false);
//            	 ar.closeWindow();
//            	ar=new AriyaRemot(2);
//            	// System.out.println("2");
            	 ar.setImage(2);
             }

             else if(ch[0]=='3'){
//            	 ar.fm.setVisible(false);
//            	 ar.closeWindow();
//            	 ar=new AriyaRemot(3);
            	 ar.setImage(3);
            	// System.out.println("3");
               	
             }

             else if(ch[0]=='4')
             {
//            	 ar.fm.setVisible(false);
//            	 ar.fm.remove(ar.fm);
//            	 ar=new AriyaRemot(4);
            	 ar.setImage(4);
            	// System.out.println("4");
             }
            
             
            }
            
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Process the command from client
     * @param command the command code
     */
    private void processCommand(int command) {
        try {
            Robot robot = new Robot();
            switch (command) {
                case KEY_RIGHT:
                    robot.keyPress(KeyEvent.VK_RIGHT);
                    System.out.println("Right");
                    break;
                case KEY_LEFT:
                    robot.keyPress(KeyEvent.VK_LEFT);
                    System.out.println("Left");
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}