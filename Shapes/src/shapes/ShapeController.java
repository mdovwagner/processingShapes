package shapes;

import java.util.ArrayList;

import processing.core.*; 
import interfascia.*;

public class ShapeController {
	
	protected static PApplet pa;
	protected static ArrayList<Shape> shapes;
	protected static ShapeControllerHelper sch;
	protected static GUIController c;
	
	public static void make(PApplet pa) {
		ShapeController.pa = pa;
		c = new GUIController(pa);
		shapes = new ArrayList<Shape>();
		sch = new ShapeControllerHelper();
		
		
		
	}
	
	public static void add(Shape shp) {
		ShapeController.shapes.add(shp);
	}
	
	public static void draw() {
		for (Shape shp : ShapeController.shapes) {
			shp.draw();
		}
	}
	
	

}
