
/**
 * Write a description of class Cat here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cat
{
    // instance variables - replace the example below with your own
    private String name;
    private int hp;

    /**
     * Constructor for objects of class Cat
     */
    public Cat(String nm){
        name = nm;
        hp = 100;
    }
    
    public void meow(){
        System.out.println("Meow!");
    }
    
    /**
     * Getter method for name (attributes)
     */
    public String getName(){
        return name;
    }
    
    public int getHP(){
        return hp;
    }
    
    public void hit(int amt){
        this.hp -= amt;
    }
    
    public int claw(){
        final int MIN = 5, MAX = 20;
        return (int)(MIN + Math.random() * MAX);
    }
    
    public boolean isAlive(){
        if (this.hp <= 0){
            return false;
        }
        return true;
    }
}
