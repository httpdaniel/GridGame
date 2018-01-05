
/**
 * Write a description of class Animal here.
 *
 * @author (conor hayes)
 * @version (October 5th 2017)
 */
public abstract class Animal implements GridObject
{
    // instance variables - replace the example below with your own
    boolean hasSkin;
    boolean breathes;
    String colour;
    int energy;
    String name; // each Animal has a name
    Location location;
    
    /**
     * Constructor for objects of class Animal
     */
    public Animal()
    {
        breathes = true; //all the subclasses of Animal inherit this property and value
        hasSkin = true; // all the subclasses of Animal inherit this property and value
        colour = "grey"; //all the subclasses of Animal inherit this property and value
    }
    /**
     * move method
     * param int distance - the distance the Animal should move
     * All subclasses inherit this method
     */
    public abstract boolean move(double distance);
    
    /**
     * eat method
     * param Food food - food the Animal should eat
     * We haven't defined this yet
     * All subclasses inherit this method
     */
    public abstract boolean eat(Food food);
    
    /**
     * getter method for colour field
     * All subclasses inherit this method
     */
    public String getColour(){
        return colour;
    }
    
    /**
     * getter method for colour field
     * All subclasses inherit this method
     */
    
    public int getEnergy(){
        return energy;
    }
    
    
     /**
     * 'getter' method for haSkin field
     * All subclasses inherit this method
     */
    
    public boolean hasSkin(){
        return hasSkin;
    }
    
    @Override
    public String getName(){
        String str = name;
        str+=" the ";
        Class cls = getClass();
        String className = cls.getSimpleName();
        str+= className;
        return str;
    }
    
    
    public boolean move(Location destination){
        
        double distance = location.distanceTo(destination);
        if(move(distance)){ // if the Canary can move this distance
            location.setGridObject(null);// resets the location's grid object to be null
            setLocation(destination);
            return true; // return 
        }
        
        return false; // otherwise return false
    }
    
    @Override
    public void setLocation(Location loc){
        if(loc==null){
            location.setGridObject(null);
            location = loc;
            System.out.println(getName() + " with energy " + getEnergy() + " has been removed from the Grid" );
            return;
        }
        
        location = loc;
        location.setGridObject(this);
        
        System.out.println(getName() + " is  at " + loc);
    }
    
    public Location getLocation(){
        return location;
    }
    
    
    
}
