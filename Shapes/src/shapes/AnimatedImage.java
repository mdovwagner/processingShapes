package shapes;

import processing.core.*;
import java.lang.Math;
import java.util.*;

public class AnimatedImage extends Rect {
  private ArrayList<PImage> imgs;
  private int index;
  private int speed = 1;
  private boolean isAnimating = false;
  
  public AnimatedImage(String[] is, float x, float y, float w, float h) {
    super(x,y,w,h);
    imgs = new ArrayList<PImage>();


    for (int i = 0; i < is.length; i++) {
      imgs.add(pa.loadImage(is[i]));
    }
  }

  public AnimatedImage(String s, int n, float x, float y, float w, float h) {
    super(x,y,w,h);
    imgs = new ArrayList<PImage>();


    for (int i = 0; i < n; i++) {
      imgs.add(pa.loadImage(s + PApplet.str(i) + ".png"));
    }
  }

  public boolean isAnimating() {
    return isAnimating;
  }

  public int getSpeed() {
    return 101-speed;
  }

  public int getIndex() {
    return index;
  }
  
  public void drawShape() {
    if (isAnimating) {
        if (pa.frameCount % speed == 0	) {
          index++;
        }
    }
    if (index >= imgs.size()) {
      index = 0;
    }
    pa.image(imgs.get(index),x,y,width,height);
  }

  public void setFrameIndex(int i) {
    index = i;
  }

  public void startAnimating() {
    isAnimating = true;
  }

  public void stopAnimating() {
    isAnimating = false;
  }

  public void setSpeed(int s) {
    // 1 to 100
    speed = Math.max(1,101-s);
  }

  public void addImage(String i) {
    imgs.add(pa.loadImage(i));
  }


  public void removeImage(int i) {
    imgs.remove(i);
  }

  public int getImageCount() {
    return imgs.size();
  }
    
}