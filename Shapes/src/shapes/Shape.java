package shapes;

import processing.core.*;

public class Shape {
  protected PApplet pa = ShapeController.pa;

  protected int fill = Color.WHITE;
  protected int stroke = Color.BLACK;
  protected float strokeWeight = 1;
  protected boolean hidden = false;
  protected float x,y;
  
  public Shape(float x, float y) {
      this.x = x;
      this.y = y;
      ShapeController.add(this);
  }
  
  public void draw() {
      pa.fill(fill);
      pa.stroke(stroke);
      pa.strokeWeight(strokeWeight);
      if (!hidden) {
          drawShape();
      }
  }
  
  public void drawShape() {
      
  }

  public float getX() {
    return x;
  }

  public float getY() {
    return y;
  }

  public int getFill() {
    return fill;
  }

  public int getStroke() {
    return stroke;
  }

  public float getStrokeWeight() {
    return strokeWeight;
  }

  public boolean getHidden() {
    return hidden;
  }

  public void setX(float x) {
    this.x = x;
  }

  public void setY(float y) {
    this.y = y;
  }

  public void setFill(int fill) {
    this.fill = fill;
  }

  public void setStroke(int stroke) {
    this.stroke = stroke;
  }

  public void setStrokeWeight(float strokeWeight) {
    this.strokeWeight = strokeWeight;
  }

  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  // LINE/RECTANGLE
  protected boolean lineRect(float x1, float y1, float x2, float y2, float rx, float ry, float rw, float rh) {

    // check if the line has hit any of the rectangle's sides
    // uses the Line/Line function below
    boolean left =   lineLine(x1,y1,x2,y2, rx,ry,rx, ry+rh);
    boolean right =  lineLine(x1,y1,x2,y2, rx+rw,ry, rx+rw,ry+rh);
    boolean top =    lineLine(x1,y1,x2,y2, rx,ry, rx+rw,ry);
    boolean bottom = lineLine(x1,y1,x2,y2, rx,ry+rh, rx+rw,ry+rh);

    // if ANY of the above are true, the line
    // has hit the rectangle
    if (left || right || top || bottom) {
      return true;
    }
    return false;
  }

  // LINE/LINE
  protected boolean lineLine(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4) {

    // calculate the distance to intersection point
    float uA = ((x4-x3)*(y1-y3) - (y4-y3)*(x1-x3)) / ((y4-y3)*(x2-x1) - (x4-x3)*(y2-y1));
    float uB = ((x2-x1)*(y1-y3) - (y2-y1)*(x1-x3)) / ((y4-y3)*(x2-x1) - (x4-x3)*(y2-y1));

    // if uA and uB are between 0-1, lines are colliding
    if (uA >= 0 && uA <= 1 && uB >= 0 && uB <= 1) {
      return true;
    }
    return false;
  }
  
  
}