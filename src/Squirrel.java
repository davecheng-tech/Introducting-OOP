public class Squirrel {
    // INSTANCE VARIABLES 

    boolean alive;
    String name;
    String colour;
    int weight;
    int age;


    // CONSTRUCTOR

    /**
     * Creates a new Squirrel object.
     * @param name     Name of the squirrel
     * @param colour   Colour of the squirrel fur
     * @param weight   Weight of squirrel in kilograms
     * @param age      Age of squirrel in years
     */
    public Squirrel(String name, String colour, int weight, int age) {
        alive = true;
        this.name = name;
        this.colour = colour;
        this.weight = weight;
        this.age = age;
    }


    // INSTANCE METHODS

    public void jump() {
         System.out.println(this.name + " jumps.");
    }

    public void kill() {
        alive = false;
        colour = colour + " with bloodstains";
    }

    public void resurrect() {
        if (alive == false) {
            alive = true;
            colour = colour + " and a mystic aura";
        }
    }

    public void birthday() {
        System.out.println(name + " celebrates a birthday!");
        age += 1;
    }

}