
/**
 * Abstract class Vegetable - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Vegetable implements Food, GridObject 
{
    // instance variables - replace the example below with your own
    int calories;
    String name;
    
    
    public String getName(){ // concrete method
        return name;
    }
}
