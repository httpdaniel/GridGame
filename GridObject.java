
/**
 * Write a description of interface GridObject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface GridObject
{
    
    public void setLocation(Location location);
    
    public Location getLocation();
    
    public boolean move(Location destination);
    
    public int getEnergy(); // energy level for the game
    
    public String getName(); // its name  game
    
}
