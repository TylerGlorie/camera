package camera;


import java.util.*;

public class camera {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
        Scanner stdin = new Scanner(System.in);
        
        //read number of points and distance to wall
        int numPoints = stdin.nextInt();
        int d = stdin.nextInt();
        
        //if its a trick question, call it out
        if(numPoints == 0) {
        	System.out.println(0);
        	stdin.close();
        	return;
        }

        //read x-coords of the Great Occluder
        int b = stdin.nextInt();
        int e = stdin.nextInt();
        
        //initialize some variables
        int numShots = 0;
        double xCovered = -10000000000000000.0;
        
        //crate ArrayList of points
        ArrayList<point> points = new ArrayList<point>();

        int x;
        int y;
        
        //read in points
        for( int i = 0; i < numPoints; i++){
        	
        	//read x and y values for each point
            x = stdin.nextInt();
            y = stdin.nextInt();
            
            //if its on the near-side of the wall, don't add it (Won't be inside the Great Occluder).
            if(y < d) {
            		--i;
            		--numPoints;
            		continue; 
            }
            
            //create point for values
            point pI = new point(x,y);
            pI.shadow(b, e, d);
            
            //calculate shadow and add to list
            points.add(pI);
        }
        stdin.close();
        
        //sort the things by in order of appearance from the car that travels left to right
        Collections.sort(points);
        
        //iterate through the list to determine how many pictures to take
        for(int i = 0; i < points.size();i++){
        	
        	//if a new picture needs to be taken, take it, then set the latest covered x-value
	        if(points.get(i).sStart > xCovered) {
	        	numShots++;
	        	xCovered = points.get(i).sEnd;
	        }
        }
        //special case if no points or if they were all below the barrier
        if(numPoints == 0) numShots = 1;

        //return the 
        System.out.println(numShots);
    }   
}
class point implements Comparable<point> {
    public int x;
    public int y;
    //variables to store the beginning and end of the shadow on the line
    public double sStart;
    public double sEnd;

    //store position of object to use in calculations
    public point(int myX, int myY) {
            x = myX;
            y = myY;
    }

    //order from least to greatest the endind of the objects shadow.
    public int compareTo(point other) {
    	if (this.sEnd < other.sEnd - 1e-9) return -1;
		if (other.sEnd < this.sEnd - 1e-9) return 1;
		return 0;
    }
    public void shadow(int b,int e,int d){
        //allow for double arithmetic
        int dY = y-d;
        double factor = (1.0*d)/dY;


        //calculate shadowStart and shadowEnd with slope of line and distance to y=0
        this.sStart = b + factor*(b-x);
        this.sEnd   = e + factor*(e-x);
    }
}




