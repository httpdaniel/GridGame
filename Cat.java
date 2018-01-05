
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cat extends Feline 
{ 
    
    

    /**
     * Constructor for objects of class Cat
     */
    public Cat(String name)
    {
        super();
        this.name = name;
        colour = "black";
        energy = 7; // starting energy
    }

    public boolean eat(Food food){
        
        if(food==null){
            return false;
        }
        if (food instanceof Canary){
            int calories = food.extractEnergy();
            energy+=calories;
            Canary canary = (Canary)food;
            System.out.println(getName() + " has Eaten "+ canary.getName() + ". Energy level at " + getEnergy()  );
            return true;
        }else{
               System.out.println(getName() + " cannot eat a "+ food.getClass().getSimpleName() + ". Energy level at " + getEnergy()); 
        }
        
        return false;
    }
    
    
    
}
