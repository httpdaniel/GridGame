
public class Cat extends Feline 
{ 
    
    

    public Cat(String name)
    {
        super();
        this.name = name;
        colour = "black";
        energy = 7;
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
        } else {
               System.out.println(getName() + " cannot eat a "+ food.getClass().getSimpleName() + ". Energy level at " + getEnergy()); 
        }
        
        return false;
    }
    
    
    
}
