package shapes;

import processing.core.PConstants;

public class Label extends Shape {
  protected String text;
  protected float width;
  protected float height;
  protected int textSize = 20;
  protected int vAlign = PConstants.CENTER;
  protected int hAlign = PConstants.CENTER;
  protected boolean wrapped = false;
  
  
  public Label(String text, float x, float y) {
    super(x,y);
    this.text = text;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public int getTextSize() {
    return textSize;
  }

  public void setTextSize(int textSize) {
    this.textSize = textSize;
  }
  
  public void setAlignment(int a) {
	  hAlign = a;
  }
  public void setVerticalAlignment(int a) {
	  vAlign = a;
  }
  
  public void setBoundingBox(float x, float y, float width, float height) {
	  this.x = x;
	  this.y = y;
	  this.width = width;
	  this.height = height;
	  wrapped = true;
  }
  
  public void setCenter(float x, float y) {
	  wrapped = false;
	  this.x = x;
	  this.y = y;
	  
  }
  
  public void drawShape() {
    pa.textSize(textSize);
    if (wrapped) {
    	pa.text(text, x, y, width, height);
    } else {
	    pa.textAlign(hAlign,vAlign);
	    pa.text(text,x,y);
    }
  }
  
}