public class Location
{
    public final int x;
    public final int y;
    private GridObject gridObject;
    private boolean occupied;

    public Location(int x, int y)
    {
       this.x = x;
       this.y = y;
    }
    
    @Override
    public boolean equals(Object object){
        if (object==null){
          return false;  
        }
        
        if (object instanceof Location){
            Location location = (Location) object;
            
            if(location.x == x && location.y ==y){
                return true;
            }
            
        }
        return false;
    }

    public GridObject getGridObject(){
        return gridObject;
    }
    
    
    public void setGridObject(GridObject gridObject){
        if(gridObject == null){
            this.gridObject = null;
            occupied = false;
            return;
        }
        this.gridObject = gridObject;
        occupied = true;
    }
    
    public boolean isOccupied(){
        return occupied;
    }
    
    public double distanceTo(Location loc){
        double temp = (this.x- loc.x)* (this.x- loc.x) + (this.y- loc.y)*(this.y- loc.y);
        return Math.sqrt(temp);
    }
    
    
    
    @Override
    public String toString(){
        String str = "";
        str += "location " + x+","+y;
        return str;
    }
}
