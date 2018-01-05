public class Seed extends Vegetable implements Food
{
    
   private Location location;

    public Seed(String name)
    {
        super();
        calories = 10;
        this.name = name;
       
    }
    
    @Override
    public int getEnergy(){
        return calories;
    }
    
    @Override
    public int extractEnergy(){
        
        int cal = calories;
        calories = 0;
        return cal;
    }
    
    @Override
    public boolean move(Location destination){
        System.out.println(getName()+ " with "+ getEnergy() + " calories cannot move");
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
    
    @Override
    public Location getLocation(){
        return location;
    }
    
}
