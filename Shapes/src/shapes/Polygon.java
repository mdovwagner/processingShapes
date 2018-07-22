package shapes;

import processing.core.PConstants;

public class Polygon extends Shape {
  
  protected float[] xs;
  protected float[] ys;
  
  public Polygon(float ... v) {
    super(v[0],v[1]);
    this.xs = new float[v.length/2];
    this.ys = new float[v.length/2];
    for (int i = 0; i < xs.length; i++) {
      this.xs[i] = v[i*2] - x;
      this.ys[i] = v[i*2+1] - y;
    }
  }

  public float[] getXs() {
    float[] xxs = new float[xs.length];
    for (int i = 0; i < xs.length; i ++) {
      xxs[i] = xs[i] + x;
    }
    return xxs;
  }

  public float[] getYs() {
    float[] yys = new float[ys.length];
    for (int i = 0; i < ys.length; i ++) {
      yys[i] = ys[i] + y;
    }
    return yys;
  }

  public int getNumVertices() {
    return xs.length;
  }

  public void setX(int i, float v) {
    xs[i] = v-x;
  }

  public void setY(int i, float v) {
    ys[i] = v-y;
  }
  
  public void drawShape() {
    pa.beginShape();
    for (int i = 0; i < xs.length; i++) {
      pa.vertex(xs[i]+x,ys[i]+y);
    }
    pa.endShape(PConstants.CLOSE);
  }
  
  public boolean contains(float mx,float my) {
    
    int j=xs.length-1;
    boolean  oddNodes= false;
    
    for (int i=0; i<xs.length; i++) {
      if (lineLine(xs[i]+x,ys[i]+y,xs[j]+x,ys[j]+y,mx,my,pa.width,my)) {
        oddNodes=!oddNodes;
      }
      j=i; 
    }
    
    return oddNodes;
  }
  
  
}