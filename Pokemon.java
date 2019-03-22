public class Pokemon {
    private String name;
    private int number;
    private String type;
    private int hitPoints;
    private String power;

    // Constructor
    public Pokemon(int number, String name, int hitPoints, String type,  String power) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.hitPoints = hitPoints;
        this.power = power;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public String getType() {
        return type;
    }

    public void printPokemon(){
        System.out.println("Number: " + this.number + ", Name: " + this.name + ", CP: " + this.hitPoints + ", Type: " + this.type);
    }
}
