
package shapes;

import processing.core.*;
import java.lang.Math;

public class Line extends Shape {
  protected float x2,y2;
  
  public Line(float x, float y, float x2, float y2) {
    super(x,y);
    this.x2 = x2;
    this.y2 = y2;
  }
  

  public float getX2() {
    return x2;
  }

  public void setX2(float x2) {
    this.x2 = x2;
  }
  
  public void drawShape() {
    pa.line(x,y,x2,y2);
  }
  
  public boolean overlaps(Line other) {
    return lineLine(x,y,x2,y2,other.x,other.y,other.x2,other.y2);
  }
  
  public boolean overlaps(Rect other) {
    return lineRect(x,y,x2,y2,other.x,other.y,other.width,other.height);
  }
  
  public boolean overlaps(Circle other) {
    float a_to_c_x = other.x - x;
    float a_to_c_y = other.y - y;
    float a_to_b_x = x2 - x;
    float a_to_b_y = y2 - y;
    float atb2 = a_to_b_x * a_to_b_x + a_to_b_y * a_to_b_y;
    
    float atc_d_atb = a_to_c_x * a_to_b_x + a_to_c_y * a_to_b_y;
    float t = atc_d_atb / atb2;
    
    float px = x + a_to_b_x*t;
    float py = y + a_to_b_y*t;
    
    float maxX = Math.max(x,x2);
    float maxY = Math.max(y,y2);
    
    float minX = Math.min(x,x2);
    float minY = Math.min(y,y2);
    
    float ppx = Math.max(minX,Math.min(px,maxX));
    float ppy = Math.max(minY,Math.min(py,maxY));
    
    return PApplet.dist(ppx,ppy,other.x,other.y) < other.radius;
    
  }
  
  
}