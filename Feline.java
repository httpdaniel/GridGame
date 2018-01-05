public abstract class Feline extends Animal
{
    boolean hasClaws;

    @Override
    public boolean move(double distance){
      
      if(energy==0){
            System.out.println(getName() + " is out of energy and cannot move");
            return false;
      }
      
      System.out.printf(getName() + " runs %f metres.  ", distance);
      energy-=2; // loses 2 units of energy for each move
      if(energy<0){
        energy = 0; // prevents energy having a negative number  
      }
      System.out.println(getName() + " now has Energy level: " + getEnergy());
      return true;     
    }
}
