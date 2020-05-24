package yeniJavaProject;

import java.util.ArrayList;
import java.awt.Point;
import java.util.Random;

public class main {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    variable.frame = new MyFrame("slitherio");
	    variable.listOfDots = new ArrayList<Point>();
	    variable.foods = new ArrayList<Point>();
	    variable.r = new Random();
	    variable.listOfDots.add(new Point(100, 100));
	    Runner r = new Runner();
	    r.start();
	}

}
