import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

Bacteria [] one;
Food [] two; 
public void setup()   
{   
	size(600,600);
	one = new Bacteria[20];
	two = new Food[1];
	for(int i = 0; i < one.length; i++)
	{
		one[i] = new Bacteria((int)(Math.random()*600),(int)(Math.random()*600));
	}
	for(int k = 0; k < two.length; k++)
	{
		two[k] = new Food((int)(Math.random()*600),(int)(Math.random()*600)); 
	}
}   
public void draw()   
{   
	background(0);
	for(int j = 0; j < one.length; j++)
	{
		one[j].show();
		one[j].walk();
	}
		for(int l = 0; l < two.length; l++)
	{
		two[l].show();
	}
	for(int m = 0; m < one.length; m++)
	{
		for(int n = 0; n < two.length; n++)
		{
			if(one[m].newX > two[n].fX)
			{
				one[m].newX = one[m].newX-1;
			}
			else
			{
				one[m].newX = one[m].newX+1;
			}
			if(one[m].newY > two[n].fY)
			{
				one[m].newY = one[m].newY-1;
			}
			else
			{
				one[m].newY = one[m].newY+1;
			}
			if((one[m].newX + 1 == two[n].fX && one[m].newY + 1 == two[n].fY) || (one[m].newX - 1 == two[n].fX && one[m].newY - 1 == two[n].fY) || (one[m].newX + 1 == two[n].fX && one[m].newY - 1 == two[n].fY) || (one[m].newX - 1 == two[n].fX && one[m].newY + 1 == two[n].fY))
			{
				for(int k = 0; k < two.length; k++)
				{
					two[k] = new Food((int)(Math.random()*600),(int)(Math.random()*600));
				}
			}
		}
	}   
}  
public void mousePressed()
{
	for(int k = 0; k < two.length; k++)
	{
		two[k] = new Food((int)(Math.random()*600),(int)(Math.random()*600));
	}
}
class Bacteria    
{
	int newX;
	int newY;
	int color1;
	int color2;
	Bacteria(int x, int y)
	{
		newX = x;
		newY = y;
		color1 = (int)(Math.random()*127) + 70;
		color2 = (int)(Math.random()*127) + 70;
	} 
	public void walk()
	{
		newX = newX + (int)(Math.random()*5)-2;
		newY = newY + (int)(Math.random()*5)-2;
	}
	public void show()
	{
		fill(0,color1,color2);
		ellipse(newX,newY,20,20);
	} 
}
class Food
{
	int fX;
	int fY;
	Food(int a, int b)
	{
		fX = a;
		fY = b;
	}
	public void show()
	{
		noStroke();
		fill(255,0,0);
		ellipse(fX,fY,15,15);
	}
}  
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
