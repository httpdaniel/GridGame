public abstract class Bird extends Animal
{
    boolean hasFeathers;
    boolean hasWings;
    boolean flies;

    public Bird()
    {
        super(); //calls the constructor of its superclass  - Animal
        colour = "black";
        hasFeathers = true;
        hasWings = true;
        flies = true;
    }

    @Override
    public boolean move(double distance){
        
        if(energy<=0){
            System.out.println(getName() + " is now out of energy and cannot move");
            return false;
        }
        
        if(flies){
            System.out.printf(getName() + " flies %f metres. ", distance);
        }else{
            System.out.printf(getName()+ " is a bird but cannot fly. " + getName() + " walks %f metres. ", distance);
        }
        energy--;
        if(energy<0){
          energy = 0; // prevents energy having a negative number  
        }
        System.out.println(getName() + " now has Energy level: " + getEnergy());
        return true;
    }
    
    public void sing(){
        System.out.println("tra la la");
    }
    
    public boolean hasWings(){
        return hasWings;
    }
    
    public boolean hasFeathers(){
        return hasFeathers;
    }
}
