public interface GridObject
{
    
    public void setLocation(Location location);
    
    public Location getLocation();
    
    public boolean move(Location destination);
    
    public int getEnergy(); 
    
    public String getName();
    
}
