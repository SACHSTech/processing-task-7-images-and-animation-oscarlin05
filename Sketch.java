import processing.core.PApplet;
import processing.core.PImage;

/** 
 * Description: a program that has a planet bouncing around in space and another planet moving in a circular motion. 
 * @author Lin. O
 * 
 */

public class Sketch extends PApplet {
	
	PImage imgSpaceBackground;
  PImage imgPlanet;

  public void settings() {
	// put your size call here
    size(700, 700);
  }

    // declare speed 
    float fltX = 50;
    float fltY = 575;
    float fltXSpeed = 7;
    float fltYSpeed = 6;

    // declare planet coordinates 
    float fltPlanetX = 0;
    float fltPlanetY = 0;
    float fltPlanetCircle;
    float fltPlanetXSpeed = 5;
    float fltPlanetYSpeed = 5;
    float fltPlanetRadius = 275;

  public void setup() {
    // load images from files 
    imgSpaceBackground = loadImage("space.jpg");
    imgPlanet = loadImage("planet.png");
    imgPlanet.resize(100, 100);
  }

  public void draw() {

    // declare background and relocate it
    image(imgSpaceBackground, 0, -100);

    // draw circle and animate it
    stroke(0);
    fill(255, 241, 115); 
    ellipse(fltX, fltY, 50, 50);
	  
    fltX += fltXSpeed;
    fltY += fltYSpeed;

    // set boundries 
    if (fltX < 25 || fltX > 675) {
      fltXSpeed *= -1;
    }

    if (fltY < 25 || fltY > 675) {
      fltYSpeed *= -1;
    }
  
    // move the image planet in circles 
    fltPlanetCircle += (Math.PI / 100);
    fltPlanetX = (float) (300 + Math.sin(fltPlanetCircle) * fltPlanetRadius);
    fltPlanetY = (float) (300 + Math.cos(fltPlanetCircle) * fltPlanetRadius);

    image(imgPlanet, fltPlanetX, fltPlanetY);

  }
}
