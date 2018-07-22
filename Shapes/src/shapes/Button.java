package shapes;
import java.lang.reflect.Method;
import interfascia.*;

public class Button extends Shape {
	
	private IFButton ifButton;
	public Method buttonPressedMethod;
	private int prevX;

	public Button(String text, int x, int y, int w) {
		super(x, y);
		
		ifButton = new IFButton(text, x, y, w);
		ShapeController.c.add(ifButton);
		ifButton.addActionListener(this);
		prevX = x;
		
		
		// check to see if the host applet implements
	    // public void buttonPressed(Button b)
	    try {
	      buttonPressedMethod =
	        ShapeController.pa.getClass().getMethod("buttonPressed",
	                                    new Class[] { Button.class });
	    } catch (Exception e) {
	      // no such method, or an error.. which is fine, just ignore
	    }
		
	}
	

	@Override public void setHidden(boolean hidden) {
	    super.setHidden(hidden);
	    
	    if (hidden) {
	    	ifButton.setX(1000000);;
	    } else {
	    	ifButton.setX(prevX);
	    }
	 }
	
	// then later, to fire that event
	  public void makeEvent() {
	    if (buttonPressedMethod != null) {
	    try {
	    	buttonPressedMethod.invoke(ShapeController.pa, new Object[] { this });
	    } catch (Exception e) {
	      System.err.println("Disabling buttonPressed() for "  +
	                         " because of an error.");
	      e.printStackTrace();
	      buttonPressedMethod = null;
	    }
	  }
	}
	
	
	public void actionPerformed(GUIEvent e) {
		makeEvent();
	}
	
	@Override public float getX() {
		if (hidden) {
			return prevX;
		} else {
			return ifButton.getX();
		}
	}
	
	@Override public float getY() {
		return ifButton.getY();
	}
	
	@Override public void setX(float x) {
		prevX = (int) x;
	    ifButton.setX((int)x);
	}
	
	@Override public void setY(float y) {
	    ifButton.setY((int)y);
	}
	
	public String getText() {
		return ifButton.getLabel();
	}
	
	public void setText(String label) {
		ifButton.setLabel(label);
	}
	
	public float getHeight() {
	    return ifButton.getHeight();
	}
	
	public void setHeight(int height) {
	    ifButton.setHeight(height);
	}
	
	public float getWidth() {
	    return ifButton.getWidth();
	}
	
	public void setWidth(int width) {
	    ifButton.setWidth(width);
	}
	
}
