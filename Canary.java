
/**
 * Write a description of class Canary here.
 *
 * @author (Conor Hayes)
 * @version (October 5th 2017)
 */
public class Canary extends Bird implements Food
{
    

    /**
     * Constructor for objects of class Canary
     */
    public Canary(String name)
    {
        super(); // call the constructor of the superclass Bird
        this.name = name;
        colour = "yellow"; // this overrides the value inherited from Bird
        energy = 5;
    }
    
    /**
     * Sing method overrides the sing method
     * inherited from superclass Bird
     */
    @Override // good programming practice to use @Override to denote overridden methods
    public void sing(){
        System.out.println("tweet tweet tweet");
    }
    
    /**
     * toString method returns a String representation of the bird
     * What superclass has Canary inherited this method from? 
     */
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
        
        if(food instanceof Seed){ // recall the same test is done in equals
            Seed seed = (Seed)food; // then Cast the variable to a Seed variable
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
