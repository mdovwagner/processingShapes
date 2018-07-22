package shapes;

import java.lang.Math;

import processing.core.PApplet;

public class Rect extends Shape  {
  protected float width,height;
  
  public Rect(float x, float y, float w, float h) {
    super(x,y);
    width = w; height = h;
  }

  public float getWidth() {
    return width;
  }

  public float getHeight() {
    return height;
  }

  public void setWidth(float width) {
    this.width = width;
  }

  public void setHeight(float height) {
    this.height = height;
  }
  
  public void drawShape() {
    pa.rect(x,y,width,height);
  }
  
  public boolean contains(float mx,float my) {
    return x < mx && mx < x + width && y < my && my < y + height;
  }
  
  public boolean overlaps(Circle other) {
    float nearX = Math.max(x,Math.min(other.x,x+width));
    float nearY = Math.max(y,Math.min(other.y,y+height));
    return PApplet.dist(other.x,other.y,nearX,nearY) < other.radius;
  }
  
  public boolean overlaps(Line other) {
   return lineRect(other.x, other.y, other.x2, other.y2, x,y,width,height);
  }
  
  public boolean overlaps(Rect other) {
    if (x > other.x + other.width || other.x > x + width) {
      return false;
    }
    if (y > other.y + other.height || other.y > y + height) {
      return false;
    }
    return true;
  }
}