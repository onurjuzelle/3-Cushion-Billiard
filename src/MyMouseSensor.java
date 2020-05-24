package yeniJavaProject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyMouseSensor extends MouseAdapter {
	public MyMouseSensor() 
	{
		
	}
boolean mouseDown =false;
public void mousePressed(MouseEvent e) 
{
 variable.speed=20;	
 mouseDown=true;
 
 variable.size/=2;
 new Thread() 
 {
	 public void run(){
		 while (mouseDown){
			 try 
			 {
				 Thread.sleep(500);
			 }
			 catch (InterruptedException e1) {
				// TODO: handle exception
				 e1.printStackTrace();
			 }
			 variable.size--;
			 
		 }
	 }
 }.start();
}

public void mouseReleased(MouseEvent e) 
{
variable.speed=10;
variable.size*=2;
mouseDown=false;

}
	
}
