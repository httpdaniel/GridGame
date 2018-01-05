public class Canary extends Bird implements Food
{
    

    public Canary(String name)
    {
        super();
        this.name = name;
        colour = "yellow";
        energy = 5;
    }
    
    @Override
    public void sing(){
        System.out.println("tweet tweet tweet");
    }
    
    @Override
    public String toString(){
        String strng ="";
        strng+= "Canary; ";
        strng+= "name: ";
        strng+= name;
        strng+= "; ";
        strng+= "colour: ";
        strng+= colour;
        strng+= "\n";
        // TOD0 Your job is to include the fields and attributes inherited 
        //from Bird and Animal in the String representation
        return strng;
    }

    
    /**
     * equals method defines how equality is defined between 
     * the instances of the Canary class
     * param Object
     * return true or false depending on whether the input object is 
     * equal to this Canary object
     */
    
    @Override
    public boolean equals(java.lang.Object object){
        //TODO : You have to define an equals method for this class
        return false; //default equals
    }
    
    @Override
    public boolean eat(Food food){
        if(food==null){
            return false;
        }
        
        if(food instanceof Seed){
            Seed seed = (Seed)food;
            int calories = seed.extractEnergy(); // get the 
            energy +=calories;
            System.out.println(getName() + " has Eaten a "+ seed.getName() + ". Energy level at " + getEnergy());
            return true;
        }else{
            System.out.println(getName() + " cannot eat a "+ food.getClass().getSimpleName() + ". Energy level at " + getEnergy()); 
        }
        return false;
    }
    
    @Override
    public int getEnergy(){
        return energy;
    }
    
    @Override
    public int extractEnergy(){
        int cal = energy;
        energy = 0;
        return cal;
    }
    
    
    
    
}
