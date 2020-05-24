package yeniJavaProject;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.Iterator;


public class Runner extends Thread {

    public void run(){
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(variable.foods.size() < 100)
                variable.foods.add(new Point(variable.r.nextInt(900), variable.r.nextInt(900)));
            variable.a = MouseInfo.getPointerInfo();
            Point p = variable.a.getLocation();
            Point last = variable.listOfDots.get(variable.listOfDots.size() - 1);
            Point n = new Point();
            if(last.distance(p) > 5){
                n = calcCoor(last, p);
                variable.listOfDots.add(n);
                if(variable.listOfDots.size() >= variable.size){
                    for(int i = 0; i < variable.listOfDots.size() - variable.size; i++){
                        variable.listOfDots.remove(i);
                    }
                }
                System.out.println(n);
            }
            Iterator<Point> i = variable.foods.iterator();
            while(i.hasNext()){
                Point food = i.next();
                if(food.distance(n) < 20){
                    i.remove();
                    variable.size++;
                }
            }
           variable.frame.repaint();
        }

    }
    public Point calcCoor(Point last, Point mouse){
        double degree = 0;
        if(last.x < mouse.x && last.y < mouse.y){
            degree = 360 - Math.toDegrees(Math.atan((double) (mouse.y - last.y) / (mouse.x - last.x)));
        }else if(last.x > mouse.x && last.y > mouse.y){
            degree = 180 - Math.toDegrees(Math.atan((double) (last.y - mouse.y) / (last.x - mouse.x)));
        }else if(last.y > mouse.y && last.x < mouse.x){
            degree = Math.toDegrees(Math.atan((double) (last.y - mouse.y) / (mouse.x - last.x)));
        }else if(last.y < mouse.y && last.x > mouse.x){
            degree = 180 + Math.toDegrees(Math.atan((double) (mouse.y - last.y) / (last.x - mouse.x)));
        }
        Point p = new Point((int) 
                (last.x + Math.cos(Math.toRadians(degree)) * variable.speed), (int) 
                (last.y - Math.sin(Math.toRadians(degree)) * variable.speed));
        return p;
    }
	
	
}
