public abstract class Animal implements GridObject
{
    boolean hasSkin;
    boolean breathes;
    String colour;
    int energy;
    String name; // each Animal has a name
    Location location;
    
    public Animal()
    {
        // all the subclasses of Animal inherit these properties and values
        breathes = true;
        hasSkin = true; 
        colour = "grey";
    }
    
    public abstract boolean move(double distance);
    
    public abstract boolean eat(Food food);
    
    public String getColour(){
        return colour;
    }
    
    public int getEnergy(){
        return energy;
    }
    
    
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
        if(move(distance)){
            location.setGridObject(null); // resets the location's grid object to be null
            setLocation(destination);
            return true;
        }
        
        return false;
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
