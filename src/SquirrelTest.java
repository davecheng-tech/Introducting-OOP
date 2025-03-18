public class SquirrelTest {
    public static void main(String[] args) {
        Squirrel animal1;
        Squirrel animal2;
        Squirrel animal3;
        
        // Create new Squirrel objects
        animal1 = new Squirrel("Tommy", "brown", 10, 28);
        animal2 = new Squirrel("Sally", "black", 5, 2);
        animal3 = new Squirrel("Billy", "white", 1, 1);

        // Do stuff with squirrels

        // Stuff with age and birthday() method
        System.out.println(animal1.name + " is " + animal1.age + " years old.");
        animal1.birthday();
        System.out.println(animal1.name + " is " + animal1.age + " years old.");

        // Stuff with alive state
        System.out.println(animal1.name + " has fur that is " + animal1.colour + ".");
        animal1.kill();
        System.out.println(animal1.name + " has fur that is " + animal1.colour + ".");
        animal1.resurrect();
        System.out.println(animal1.name + " has fur that is " + animal1.colour + ".");

        // Stuff with weight
        int totalWeight = animal1.weight + animal2.weight + animal3.weight;
        System.out.println("Total weight: " + totalWeight);        
    }
}
