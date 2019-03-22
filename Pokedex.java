import java.io.File;
import java.util.Scanner;

public class Pokedex {
    private String[][] pokedex;
    private Pokemon[] finalPokedex;

    // Pokedex constructor
    public Pokedex(File file) throws Exception {
        this.pokedex = processFile(file);
    }

    // processes input file into 2D jagged array
    public String[][] processFile(File input) throws Exception {
        Scanner sc = new Scanner(input);            // scanner used to check file length
        Scanner sc2 = new Scanner(input);           // scanner used to process file line by line
        String line;
        int counter = 0;

        int size = checkFileLength(sc);

        pokedex = new String[size][];               // initializes 2d array corresponding to length of file

        while (sc2.hasNextLine()) {
            line = sc2.nextLine();
            String[] processedLine = line.split(",", 0);
            pokedex[counter] = new String[processedLine.length];
            for (int i = 0; i < processedLine.length; i++) {
                pokedex[counter][i] = processedLine[i];
            }
            counter++;
        }
        finalPokedex = objectify();
        return pokedex;
    }

    // parses 2d array into array of Pokemon Objects
    public Pokemon[] objectify(){
        Pokemon[] pokemonList = new Pokemon[pokedex.length];
        for (int i = 0; i < pokedex.length; i++){
            Pokemon pokemon = new Pokemon(Integer.parseInt(pokedex[i][0]), pokedex[i][1], Integer.parseInt(pokedex[i][2]),pokedex[i][3], pokedex[i][4]);
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
        for (int i = 0; i < pokedex.length; i++) {
            for (int j = 0; j < pokedex[i].length; j++) {
                System.out.println(pokedex[i][j]);
            }
        }
    }

    public String[][] getPokedex() {
        System.out.println(pokedex);
        return pokedex;
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

    public void lookupByName(){
        Scanner NameScanner = new Scanner(System.in);
        System.out.println("Enter a Pokemon name: ");
        String userIn = NameScanner.next();

        for (String[] i : pokedex){
            if (i[0] == userIn){
                printPokemon();
            } else {
                System.out.println("Pokemon is not in Pokedex");
            }
        }
    }

    public void lookupByNumber(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a Pokemon Number: ");
        int num = scan.nextInt();
        for (int i = 0; i < finalPokedex.length; i++) {
            if (num == finalPokedex[i].getNumber()){
                finalPokedex[i].printPokemon();
            }
        }
    }

    public void lookupByType(){
        //todo
    }

    public void averageHitPoints(){
        //todo
    }

    public void printPokemon(){
        // todo
    }

    public static void main(String[] args) throws Exception {
        File file = new File("pokedex.txt");
        Pokedex pokedex = new Pokedex(file);
        //Pokemon[] pokedex = pokedex.objectify();




    }
}
