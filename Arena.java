
/**
 * Where the cat and dog fight 
 *
 * @author Snigdha Mundra
 * @version 18/03/2021
 */
public class Arena
{
    // instance variables - replace the example below with your own
    private final int MAXCATS = 9, MAXDOGS = 5;
    
    //Going to make arrays of dogs and cats holding objects
    private Dog[] dogs = new Dog[MAXDOGS];
    private Cat[] cats = new Cat[MAXCATS];

    /**
     * Constructor for objects of class Arena
     */
    public Arena()
    {
        this.fillKennel();
    }

    public void fillKennel(){
        for (int i = 0; i < dogs.length; i++){
            dogs[i] = new Dog("Dog " + Integer.toString(i+1));
            System.out.print(dogs[i].getName() + " goes");
            dogs[i].bark();
            System.out.println();
        }
        
        for (int i = 0; i < cats.length; i++){
            cats[i] = new Cat("Cat " + Integer.toString(i+1));
            System.out.print(cats[i].getName() + " goes");
            cats[i].meow();
            System.out.println();
        }
    }  
    
    public void dogAttack(Dog dog, Cat cat){
        System.out.println(dog.getName() + " bites " + cat.getName());
        cat.hit(dog.bite());
        
        // Check if the cat is still alive
        if (!cat.isAlive()){
            System.out.println(cat.getName() + " is dead :(");
        }
    }
    
    public void catAttack(Cat cat, Dog dog){
        System.out.println(cat.getName() + " claws " + dog.getName());
        dog.hit(cat.claw());
        
        // Check if the cat is still alive
        if (!dog.isAlive()){
            System.out.println(dog.getName() + " is dead :(");
        }
    }
    
    public void fight(){
        //Pick a random number for the cat that attacks
        int first;  //Chooses who is the first attacker, 0 if cat
        int attacker, defender;
        boolean end = false;
        
        
        int randomCat; 
        int randomDog;
        
        while (!end){
            first = (int)(Math.random()); //Choose first attacker
            
            //cat attacks first
            if (first <= 1){
                //choose which cat
                do{
                    attacker = (int)(Math.random() * MAXCATS);
                } while (cats[attacker].isAlive() == false);
                // choose which dog
                do{
                    defender = (int)(Math.random() * MAXDOGS);
                } while (dogs[defender].isAlive() == false);
                catAttack(cats[attacker], dogs[defender]);
                dogAttack(dogs[defender], cats[attacker]);
            
            }
            
            
            if (first <= 1){
                //choose which dog
                do{
                    attacker = (int)(Math.random() * MAXDOGS);
                } while (dogs[attacker].isAlive() == false);
                // choose which cat
                do{
                    defender = (int)(Math.random() * MAXCATS);
                } while (cats[defender].isAlive() == false);
                
                dogAttack(dogs[attacker], cats[defender]);
                catAttack(cats[defender], dogs[attacker]);
            }
            
            
            // Check Winner
            if (checkWinner() == 0){
                System.out.println("All cats are dead, dogs win!");
                end = true;
            } else if(checkWinner() == 1){
                System.out.println("All dogs are dead, cats win!");
                end = true;
            }
        }
    }
    
    /**
     * Check if all the cats or dogs are alive
     * 
     * @return int 0 if cats are all dead, 1 if dogs
     */
    public int checkWinner(){
        int catsAlive = MAXCATS, dogsAlive = MAXDOGS;
        
        for (Cat cat: cats){
            if (!cat.isAlive()){
                catsAlive--;
            }
        }
        for (Dog dog: dogs){
            if (!dog.isAlive()){
                dogsAlive--;
            }
        }
        
        if (catsAlive == 0){
            return 0;
        } else if (dogsAlive == 0){
            return 1;
        }
        return -1;
    }
}
