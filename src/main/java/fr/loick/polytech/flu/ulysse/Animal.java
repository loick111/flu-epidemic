//package foxesandrabbits.v1;

import java.util.List;

public abstract class Animal
{
    protected boolean alive;
    protected Field field;
    protected Location location;
    protected int age=0;

    public Animal(Field field, Location location)
    {
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
  
    abstract public void act(List<Animal> newAnimals);
    abstract public int getBreedingAge();
    abstract public int breed();
    
    protected boolean isAlive()
    {
        return alive;
    }

    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }
    abstract public void incrementAge();
    
  
    protected Location getLocation()
    {
        return location;
    }
    
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    
   
    protected Field getField()
    {
        return field;
    }
    protected void giveBirth(List<Animal> newAnimales,String type) {
        
        List<Location> free = field.getFreeAdjacentLocations(location);
        int births = breed();
        for (int b = 0; b < births && free.size() > 0; b++) {
            Location loc = free.remove(0);
			if(type.equals("fox")){
			Fox young= new Fox(true, field,loc);
            newAnimales.add( young);
			}
			
			if(type.equals("rabbit")){
            Animal young = new Rabbit(true, field, loc);
            newAnimales.add(young);
            //
            }
        }
    }

}//

