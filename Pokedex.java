import java.io.File;
import java.util.Scanner;

public class Pokedex {
    private String[][] initialPokedex;

    // Pokedex constructor
    public Pokedex(File file) throws Exception {
        this.initialPokedex = processFile(file);
    }

    // processes input file into 2D jagged array
    public String[][] processFile(File input) throws Exception {
        Scanner sc = new Scanner(input);            // scanner used to check file length
        Scanner sc2 = new Scanner(input);           // scanner used to process file line by line
        String line;
        int counter = 0;

        int size = checkFileLength(sc);

        initialPokedex = new String[size][];               // initializes 2d array corresponding to length of file

        while (sc2.hasNextLine()) {
            line = sc2.nextLine();
            String[] processedLine = line.split(",", 0);
            initialPokedex[counter] = new String[processedLine.length];
            for (int i = 0; i < processedLine.length; i++) {
                initialPokedex[counter][i] = processedLine[i];
            }
            counter++;
        }
        return initialPokedex;
    }

    // parses 2d array into array of Pokemon Objects
    public Pokemon[] objectify(){
        Pokemon[] pokemonList = new Pokemon[initialPokedex.length];
        for (int i = 0; i < initialPokedex.length; i++){
            Pokemon pokemon = new Pokemon(initialPokedex[i][0], Integer.parseInt(initialPokedex[i][1]), initialPokedex[i][2], Integer.parseInt(initialPokedex[i][3]), initialPokedex[i][4]);
            pokemonList[i] = pokemon;
        }
        
        return pokemonList;
    }

    // checks length of file
    public int checkFileLength(Scanner scanner) {
        int fileLength = 0;

        while (scanner.hasNextLine()) {
            scanner.nextLine();
            fileLength++;
        }

        return fileLength;
    }


    public void printPokedex() {
        for (int i = 0; i < initialPokedex.length; i++) {
            for (int j = 0; j < initialPokedex[i].length; j++) {
                System.out.println(initialPokedex[i][j]);
            }
        }
    }

    public String[][] getPokedex() {
        System.out.println(initialPokedex);
        return initialPokedex;
    }

    public void printMenu() throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Print Pokedex");
        System.out.println("2. Print Pokemon by Name");
        System.out.println("3. Print Pokemon by Number");
        System.out.println("4. Count Pokemon with Type");
        System.out.println("5. Print Average Pokemon Combat Points");
        System.out.println("6. Quit");
        System.out.println();
        System.out.println("Please enter a menu item: ");

        int input = scanner.nextInt();
        menuChoice(input);
    }

    public void menuChoice(int choice){
        switch(choice){
            case 1: printPokedex();
            break;

            case 2: lookupByName();
            break;

            case 3: lookupByNumber();
            break;

            case 4: lookupByType();
            break;

            case 5: averageHitPoints();
            break;

            case 6: break;
        }
    }

    public String lookupByName(){
        Scanner NameScanner = new Scanner(System.in);
        System.out.println("Enter a Pokemon name: ");
        String userIn = NameScanner.next();

        for (String[] i : initialPokedex){
            if (i[0] == userIn){
                printPokemon();
            } else {
                System.out.println("Pokemon is not in Pokedex");
            }
        }

        return
    }

    public String lookupByNumber(){
        return something
    }

    public String lookupByType(){
        return something
    }

    public String averageHitPoints(){
        return something
    }

    public void printPokemon(){
        // todo
    }

    public static void main(String[] args) throws Exception {
        File file = new File("initialPokedex.txt");
        Pokedex initialPokedex = new Pokedex(file);
        Pokemon[] pokedex = initialPokedex.objectify();




    }
}
