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
        return strng;
    }

    
    @Override
    public boolean eat(Food food){
        if(food==null){
            return false;
        }
        
        if(food instanceof Seed){
            Seed seed = (Seed)food;
            int calories = seed.extractEnergy();
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
