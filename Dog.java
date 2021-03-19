
/**
 * Write a description of class Dog here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Dog
{
    // instance variables - replace the example below with your own
    private String name;
    private int hp;

    /**
     * Constructor for objects of class Dog
     */
    public Dog(String nm){
        name = nm;
        hp = 120;
    }
    
    public void bark(){
        System.out.println("Woof!");
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
    
    public int bite(){
        final int MIN = 1, MAX = 12;
        return (int)(MIN + Math.random() * MAX);
    }
    
    public boolean isAlive(){
        if (this.hp <= 0){
            return false;
        }
        return true;
    }
}
