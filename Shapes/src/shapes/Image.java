package shapes;

import processing.core.*;

public class Image extends Rect {
  protected PImage img;
  protected String imgtext;
  
  public Image(String i, float x, float y, float w, float h) {
    super(x,y,w,h);
    imgtext = i;
    img = pa.loadImage(i);
    
  }

  public String getImage() {
    return imgtext;
  }

  public void setImage(String i) {
    img = pa.loadImage(i);
    imgtext = i;
  }
  
  public void drawShape() {
    pa.image(img,x,y,width,height);
  }
  
}