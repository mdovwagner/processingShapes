package shapes;

import java.lang.Math;
import processing.core.PApplet;

public class Circle extends Shape {
  protected float radius;
  
  public Circle(float x, float y, float radius) {
    super(x, y);
    this.radius = radius;
  }

  public float getRadius() {
    return radius;
  }

  public void setRadius(float radius) {
    this.radius = radius;
  }
  
  public void drawShape() {
    pa.ellipse(x,y,radius*2,radius*2);
  }

  
  public boolean contains(float mx,float my) {
    return Math.pow(mx - x,2) + Math.pow(my - y,2) < Math.pow(radius,2);
  }
  
  public boolean overlaps(Circle other) {
    return PApplet.dist(x,y,other.x,other.y) < radius + other.radius;
  }
  
  public boolean overlaps(Rect other) {
    float nearX = Math.max(other.x,Math.min(x,other.x+other.width));
    float nearY = Math.max(other.y,Math.min(y,other.y+other.height));
    return PApplet.dist(x,y,nearX,nearY) < radius;
  }
  
  public boolean overlaps(Line other) {
    float a_to_c_x = x - other.x;
    float a_to_c_y = y - other.y;
    float a_to_b_x = other.x2 - other.x;
    float a_to_b_y = other.y2 - other.y;
    float atb2 = a_to_b_x * a_to_b_x + a_to_b_y * a_to_b_y;
    
    float atc_d_atb = a_to_c_x * a_to_b_x + a_to_c_y * a_to_b_y;
    float t = atc_d_atb / atb2;
    
    float px = other.x + a_to_b_x*t;
    float py = other.y + a_to_b_y*t;
    
    float maxX = Math.max(other.x,other.x2);
    float maxY = Math.max(other.y,other.y2);
    
    float minX = Math.min(other.x,other.x2);
    float minY = Math.min(other.y,other.y2);
    
    float ppx = Math.max(minX,Math.min(px,maxX));
    float ppy = Math.max(minY,Math.min(py,maxY));
    
    return PApplet.dist(ppx,ppy,x,y) < radius;
    
  }
}