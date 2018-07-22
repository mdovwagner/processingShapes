package shapes;
import java.lang.reflect.Method;
import interfascia.*;


public class TextField extends Shape {
	private IFTextField ifTextField;
	public Method textCompletedMethod;
	public Method textModifiedMethod;
	private int prevX;
	
	public TextField(int x, int y, int width) {
		super(x, y);
		prevX = x;
		ifTextField = new IFTextField("",x,y,width);
		ShapeController.c.add(ifTextField);
		ifTextField.addActionListener(this);
		
		// check to see if the host applet implements
	    // public void textCompleted(TextField tf)
	    try {
	      textCompletedMethod =
	        ShapeController.pa.getClass().getMethod("textCompleted",
	                                    new Class[] { TextField.class });
	    } catch (Exception e) {
	      // no such method, or an error.. which is fine, just ignore
	    }
	    // check to see if the host applet implements
	    // public void textModified(TextField tf)
	    try {
	    	textModifiedMethod =
	        ShapeController.pa.getClass().getMethod("textModified",
	                                    new Class[] { TextField.class });
	    } catch (Exception e) {
	      // no such method, or an error.. which is fine, just ignore
	    }
	}
	
	public void actionPerformed(GUIEvent e) {
		if (e.getMessage().equals("Completed")) {
			makeCompletedEvent();
		}
		if (e.getMessage().equals("Modified")) {
			makeModifiedEvent();
		}
	}
	
	
	
	public void makeCompletedEvent() {
	    if (textCompletedMethod != null) {
	    try {
	    	textCompletedMethod.invoke(ShapeController.pa, new Object[] { this });
	    } catch (Exception e) {
	      System.err.println("Disabling textCompleted() for "  +
	                         " because of an error.");
	      e.printStackTrace();
	      textCompletedMethod = null;
	    }
	  }
	}
	
	public void makeModifiedEvent() {
	    if (textModifiedMethod != null) {
	    try {
	    	textModifiedMethod.invoke(ShapeController.pa, new Object[] { this });
	    } catch (Exception e) {
	      System.err.println("Disabling textModified() for "  +
	                         " because of an error.");
	      e.printStackTrace();
	      textModifiedMethod = null;
	    }
	  }
	}
	
	@Override public void setHidden(boolean hidden) {
	    super.setHidden(hidden);
	    
	    if (hidden) {
	    	ifTextField.setX(100000);
	    } else {
	    	ifTextField.setX(prevX);
	    }
	 }
	
	public String getText() {
		return ifTextField.getValue();
	}
	
	
	@Override public float getX() {
		if (hidden) {
			return prevX;
		}
		else {
			return ifTextField.getX();
		}
	}
	
	@Override public float getY() {
	    return ifTextField.getY();
	}
	
	@Override public void setX(float x) {
		prevX = (int)x;
		ifTextField.setX((int)x);
	}
	
	@Override public void setY(float y) {
		ifTextField.setY((int)y);
	}
	
	
	public void setText(String label) {
		ifTextField.setValue(label);
	}
	
	public float getHeight() {
	    return ifTextField.getHeight();
	}
	
	public void setHeight(int height) {
		ifTextField.setHeight(height);
	}
	
	public float getWidth() {
	    return ifTextField.getWidth();
	}
	
	public void setWidth(int width) {
		ifTextField.setWidth(width);
	}

}
