package shapes;

public class ShapeControllerHelper {
	
	public ShapeControllerHelper() {
		ShapeController.pa.registerMethod("draw",this);
	}
	
	public void draw() {
		ShapeController.draw();
	}

}
