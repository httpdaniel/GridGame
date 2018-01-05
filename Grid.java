import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;

public class Grid
{
    private int size;
    private ArrayList<Location> locations;
    private ArrayList<GridObject> gridObjects = new ArrayList();
    
    public Grid(int size)
    {
       this.size = size;
       locations = new ArrayList(size*size);
       
       for(int i = 0; i< size; i++){
           for(int j = 0; j < size; j++){
               locations.add(new Location(i,j));
           }
        }
   
    }

    public void addAvatar(GridObject gridObject, int x, int y){
        gridObjects.add(gridObject);
        int index = size * x + y;
        Location location = locations.get(index);
        location.setGridObject(gridObject);
        gridObject.setLocation(location);
    }
    
    public static void main(String[] args){
        Grid grid = new Grid(5);
        
        Seed seed = new Seed("Poppy seed");
        Seed seed2 = new Seed("Hay seed");
        Seed seed3 = new Seed("Wheat seed");
        Seed seed4 = new Seed("Oat seed");
        Seed seed5 = new Seed("Sunflower seed");
        
        grid.addAvatar(seed, 0, 0); // add the seed to the Grid at location 0,0
        grid.addAvatar(seed2, 0, 1);
        grid.addAvatar(seed3, 0, 2);
        grid.addAvatar(seed4, 0, 3);
        grid.addAvatar(seed5, 0, 4);
        
        Canary topsie = new Canary("Topsie");
        Canary tim = new Canary("Tim");
        Canary bluey = new Canary("Bluey");
     
        grid.addAvatar(topsie,4,4); //add topsie at location 4,4
        grid.addAvatar(tim,3,4);
        grid.addAvatar(bluey,2,4);
        
        Cat felix = new Cat("Felix");
        grid.addAvatar(felix,1,3);
        
        grid.start(24); // execute the game instructions
        
    }
    
    
    
    public void start(int rounds){
        
        for(int i = 0; i< rounds; i++){ //run the programme for this numner of rounds
            System.out.println();
            System.out.println("*** round " +i+ " ***");
            System.out.println();
            for(GridObject gridObject: gridObjects){ //for each gridObject
                if(gridObject instanceof Animal){ // if the gridObject can move
                    Animal animal = (Animal)gridObject; // cast a new variable to Animal Type
                    Location destination = null; // create a variable for the destination
                    while(destination == null || (gridObject.getLocation()==destination)){ // makes sure that the random location is not the same as location
                        destination = getRandomLocation(); // select a random destination to move to
                    } 
                    if(!destination.isOccupied()){ // check if the desination is occupied
                       animal.move(destination); // if not occupied, just move to the destination location
                    }else{
                       GridObject occupant =  destination.getGridObject(); // get the occupant at the destination location
                       if(occupant instanceof Food){ // if it is a type of food
                          Food food = (Food)occupant; // cast occupant to a Food type
                          Location startLocation = gridObject.getLocation();  // get its location 
                          animal.move(destination); //move to the desination location. This displaces occupant
                          if(!animal.eat(food)){ // Now try to eat the  occupant. Return false if inedible
                            animal.move(startLocation); // if it fails to eat, it must move back to its startLocation
                            occupant.setLocation(destination); // reinstate the occupant's location   
                          }
                       } else{
                         System.out.println(gridObject.getName() + " cannot move to location "+ occupant.getLocation() +" occuppied by " + occupant.getName());
                       }
                     }
                 }else{
                    System.out.println(gridObject.getName() + " at " +gridObject.getLocation() +" with calories " + gridObject.getEnergy() + " cannot move");
                 }
            }
            
            removeDeadObjects(); // remove zero energy objects
            
            if(isFinished()){ // isFinished checks if there is one Animal left on the grid
                System.out.println();
                System.out.println("********* GAME OVER ***********");
                break; //break out the the rounds loop
            }
        }
    }
    
   
    public Location getRandomLocation(){
        int randIndex = (int)(Math.random() * size * size);
        return locations.get(randIndex);
    }
    
    
    private void removeDeadObjects(){ 
        Iterator<GridObject> it = gridObjects.iterator(); 
            while(it.hasNext()){
               GridObject gridObject = it.next();
               if(gridObject.getEnergy()<=0){
                   gridObject.setLocation(null);
                   it.remove();
               }
            }
    }
    
    private boolean isFinished(){ 
        int animals=0;
        ArrayList<GridObject> remainingAnimals = new ArrayList();
        for(GridObject gridObject: gridObjects){
            if(gridObject instanceof Animal){
                remainingAnimals.add(gridObject);
            }
        }
        
        if(remainingAnimals.size()==0){
            System.out.println();
            System.out.println("All Animals have transpired. There is no winner" );
            return true;
        }
        
        if(remainingAnimals.size()==1){
            GridObject winner = remainingAnimals.get(0);
            System.out.println();
            System.out.println(winner.getName().toUpperCase() + " is the winner with energy level " + winner.getEnergy());
            return true;    
        }
        return false;
    }
    
    
}
