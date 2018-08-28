/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

import java.util.Scanner;
import java.io.IOException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.File;
import java.util.Random;
import java.io.FileReader;
import java.io.BufferedReader;


/**
 *
 * @author Hamish
 */
public class FootballManager implements MainManager {

    private final ArrayList<FootballTeam> league;
    private final Scanner scanner;
    private final ArrayList<Player> playerList;
    private final ArrayList<PlayGame> matches;
    String fileout;

    /**
     *
     * @author Hamish Maritz Constructor for the League, PlayerList and Matches
     * ArrayLists Number Of Clubs in Football Manager Calls the input method
     * initializing the Football Manager
     *
     */
    public FootballManager() {

        // this.numberOfClubs = numberOfClubs;
        league = new ArrayList<>();
        scanner = new Scanner(System.in);
        playerList = new ArrayList<>();
        matches = new ArrayList<>();
        input();
    }

    /**
     *
     * @param args
     * Calls the Variable PM initiating the program
     */
    public static void main(String[] args) {

        FootballManager pm = new FootballManager();
    }

    /**
     * Method that calls the Input Menu for the Football Manager This Method is
     * the Main Menu for the Program Called from @FootballManager(Line 59).
     *
     */
    public void input() {

        // Reads in Team and Players Input File 
        File p = new File("team.txt");
        File t = new File("players.txt");
        
        // This checks to see if The Player and Team Files Exist
        // If these Files Exist Then Call These Methods
        // If These Files Do Not Exist, It will Skip Over Them
        if(p.exists()){
         readTeam(); 
        } 
        if(t.exists())
        {  
        readPlayers();
        }
        
        while (true) {
            System.out.println("|------------------------------------------------|");
            System.out.println("| Hello and welcome to the Football Manager 2019 |");
            System.out.println("|------------------------------------------------|");
            // Program Will Pause for 1000ms
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Menu Is Displayed
            System.out.println("Please Select From The Menu Your Desired Option");
            System.out.println("1. Play A Game");
            System.out.println("2. Manage Your Team");
            System.out.println("3. List Clubs");
            System.out.println("4. Exit");

            String line = scanner.nextLine();
            int command = 0;

            // Checks for Invalid Input
            try {
                command = Integer.parseInt(line);
            } catch (NumberFormatException ex) {
                System.out.println("Please Enter A Number!");
            }
            // Switch that calls methods from User Input
            switch (command) {
                case 1:
                    playGame();
                    break;
                case 2:
                    manageTeamMenu();
                    break;
                case 3:
                    printClubs();
                    break;
                case 4:
                    exitGame();
                default:
                    System.out.println("Returning...");
            }

        }
    }

    /**
     * Calls the Manage Team Menu Method Prints the Manage Team Method Users can
     * select from Menu to Add Team, Add Players, Remove Players, Trade Players
     * Display All Players and Teams and Return Utilizes Switch to call methods
     * per user selection.
     */
    public void manageTeamMenu() {

        while (true) {
            System.out.println("Welcome to the Team Management Menu: ");

            // Method will pause for 1000ms   
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("The League Current Teams Are:");
            // Method will pause for 1000ms  
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            // Prints out the current Teams in League
            for (FootballTeam team : league) {
                System.out.println(" " + team.getName());
            }
            // Program wll pause for 1000ms
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            System.out.println("|-------------------------------|");
            System.out.println("What would you like to manage?");
            System.out.println("1. Add A Team");
            System.out.println("2. Add Players");
            System.out.println("3. Remove Players");
            System.out.println("4. Trade Players");
            System.out.println("5. Display All Players and Teams");
            System.out.println("6. Return");

            String line = scanner.nextLine();
            int command = 0;

            // Checks for Invalid Input
            try {
                command = Integer.parseInt(line);
            } catch (NumberFormatException e) {

                System.out.println("That is not a number!");
            }
            // Switch that calls method from User Input
            switch (command) {
                case 1:
                    addTeam();
                    break;
                case 2:
                    addPlayer();
                    break;
                case 3:
                    removePlayer();
                    break;
                case 4:
                    tradePlayer();
                    break;
                case 5:
                    displayRoster();
                case 6:
                    return;
                default:
                    System.out.println("Returning...");
            }

        }

    }

    /**
     * Add Team Method that is called from the Manage Team Menu(Line 155) Add
     * Team Creates a new FootballTeam Object and stores it into the League
     * ArrayList.
     *
     * The saveTeam() method is called at the end to save output to text file
     * "team.txt"
     *
     *
     */
    public void addTeam() {

        // If League has more than 20 Teams, Print out full
        if (league.size() == 20) {
            System.out.println("Club List Is Full");
        }

        // New Team Object for storing Team Information
        FootballTeam team = new FootballTeam();

        System.out.println("Enter Club Name");
        String line = scanner.nextLine();
        // Checks to see if League Contains Existing Team
        team.setTeamName(line);

        if (league.contains(team)) {
            System.out.println("Already Exists!");
            input();
        } else {
            // Sets Team Name
            team.setTeamName(line);
            
            System.out.println("Enter the club location: ");
           
            line = scanner.nextLine();
            // Sets Team Location
            
            team.setTeamLocation(line);
            // Adds Team to League ArrayList
            league.add(team);
            
            // Saves Team to Output Text File "team.txt"
            saveTeam();
        }

    }

    /**
     * The Print Club Method is called to display the list of current teams
     * inside the league array.
     */
    public void printClubs() {

        // Iterates through League and prints out the current Teams/Club
        for (SportsClub c : league) {     
            
            System.out.print("| Team: " + c.getName() + " Location:" + c.getLocation());
            for(int i= 0; i < c.getName().length(); i++){
            System.out.print(" ");
            }
            System.out.println("");
        }
    }

    /**
     * Play Game method is called to play a game The user is able to select two
     * teams from the league A random number between 1 and 2 is generated If 1
     * is selected then the Home Team wins and gains a point If 2 is selected
     * then the Away Team wins and gains a point If a team loses, the team is
     * deducted a point The saveWins() method is called to save and store the
     * win count in a text file named "teamwins.txt".
     */
    public void playGame() {

        System.out.println("Welcome to play a game");
        System.out.println("Enter Home Team: ");
        String line = scanner.nextLine();
        // Checks for Invalid Input
        try {
            Integer.parseInt(line);
            System.out.println("Number's are not permitted!");
        } catch (NumberFormatException exception) {

        }

        // Checks to see if Home Team Exists, If Exists then sets Home Team as 
        // The User Input Team.
        // If Home Team Does Not Exist, Then Print Out No Club Exists
        FootballTeam home = null;
        for (FootballTeam club : league) {
            if (club.getName().equals(line)) {
                home = club;
            }
        }
        if (home == null) {
            System.out.println("No such club in league");
            return;
        }

        System.out.println("Enter Away Team: ");
        line = scanner.nextLine();
        // Checks for Invalid Input
        try {
            Integer.parseInt(line);
            System.out.println("Number's are not permitted!");
        } catch (NumberFormatException exception) {

        }

        // Checks to see if Away Team Exists, If Exists then sets Away Team as 
        // The User Input Team.
        // If Away Team Does Not Exist, Then Print Out No Club Exists
        
        FootballTeam away = null;
        for (FootballTeam club : league) {
            if (club.getName().equals(line)) {
                away = club;
            }
        }
        if (away == null) {
            System.out.println("No such club in league");
            return;
        }

        // After User Input, Game Is Then Run
        {
            System.out.println("-----------------------");
            System.out.println("  It's Kick Off Time!! ");
            System.out.println("------------------------");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("Generating...");
            // Thread sleeps for 1000ms
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("Generating...");
            // Thread sleeps for 1000ms
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("Final Results From Match!");
            try {
                // Thread sleeps for 1000ms
                Thread.sleep(1000);
            } catch (InterruptedException e) {

            }

            // Sets a new Match Object from PlayGame Class
            PlayGame match = new PlayGame();

            // Sets Team1 as Home and Team2 as Away, Sets Scores as Defaults
            match.setTeam1(home);
            match.setTeam2(away);
            match.setTeam1Score(0);
            match.setTeam2Score(0);
            // Adds the Match to the Matches ArrayList
            matches.add(match);

            // Random Number Generator, Numbers between 1 and 2
            Random rand = new Random();
            int n = rand.nextInt(2) + 1;

            // If Random Number Equals 1 then Home Team has Won
            // Sets the Scores of the Away and Home Team
            if (n == 1) {
                home.setWinCount(home.getWinCount() + 1);
                away.setDefeatCount(away.getDefeatCount() + 1);
                match.setTeam1Score(match.getTeam1Score() + 1);
                match.setTeam2Score(match.getTeam2Score() - 1); // MIGHT NEED FIXING 21/AUGUST 18
                System.out.println("| ---------------------- |");
                System.out.println("  The Home Team Has Won!");
                System.out.println("| ---------------------- |");
                System.out.println(home.getName() + " Currently has: " + home.getWinCount() + " Wins!");
                System.out.println("| ---------------------- |");
                System.out.println(" ");
            }
            // If Random Number Equals 2 then Away Team has Won
            // Sets the Scores of the Away and Home Team
            if (n == 2) {
                away.setWinCount(away.getWinCount() + 1);
                home.setDefeatCount(home.getDefeatCount() + 1);
                match.setTeam2Score(match.getTeam2Score() + 1);
                match.setTeam1Score(match.getTeam1Score() - 1);
                System.out.println("| ---------------------- |");
                System.out.println("The Away Team Has Won!");
                System.out.println("| ---------------------- |");
                System.out.println(away.getName() + " Currently has: " + away.getWinCount() + " Wins!");
                System.out.println("| ---------------------- |");
                System.out.println(" ");
            }
            // Saves the Wins to the "teamwins.txt" file
            saveWins();
        }
    }

    /**
     * The method exitGame is called from the main menu to exit the program.
     */
    public static void exitGame() {
        System.out.println("Thanks for playing!");
        System.exit(0);
    }

    /**
     *
     * The addPlayer method is called from the Team Management Menu The user is
     * asked to enter the club and if the club exists then it will add a player
     * The Player is added by the Player Name and Player Number The Player is
     * then stored in the PlayerList Array.
     *
     */
    public void addPlayer() {

        while (true) {
            System.out.println("Welcome to the Add Player Management Menu: ");
            System.out.println("Enter the club: ");
            String line2 = scanner.nextLine();

            // Checks for Invalid Input
            try {
                Integer.parseInt(line2);
                System.out.println("Number's are not permitted!");

            } catch (NumberFormatException exception) {

            }

            // Creates a new FootballTeam Object and sets the TeamName as 
            // The User Input
            FootballTeam team2 = new FootballTeam();
            team2.setTeamName(line2);

            // If the League Contains the Team then Continue to Creating A Player
            if (league.contains(team2)) {

                Player player = new Player(" ", " ", " ");
                System.out.println("Enter Player Name");
                String line = scanner.nextLine();
                player.setPlayerName(line);

                // Checks for Invalid Input
                try {
                    Integer.parseInt(line2);
                    System.out.println("Number's are not permitted!");

                } catch (NumberFormatException exception) {
                   
                }

                System.out.println("Enter the player number: ");
                line = scanner.nextLine();

                // Sets the Player Number
                player.setPlayerNumber(line);

                // Sets the Players Club 
                player.setPlayerClub(line2);

                // Adds the Player to the PlayerList Array
                playerList.add(player);

                // Adds the Player to the Player Class List
                player.addPlayer(player);

                // Saves the Player to the "players.txt" output file
                savePlayers();

                // Calls the Team Management Menu
                manageTeamMenu();

            } else {

                System.out.println("|------------------------|");
                System.out.println("That Club Does Not Exist!");
                System.out.println("|------------------------|");
                input();
            }
        }
    }

    /**
     *
     * The Remove Player Method is called to remove a player from a Team This
     * method will check to see if the Player exists in the PlayerList If the
     * Player Exists, then playerList.remove is called to remove them.
     */
    public void removePlayer() {

        while (true) {
            System.out.println("Welcome to the Remove Player Menu: ");
            System.out.println("Enter the Players name: ");
            String line = scanner.nextLine();
            // Checks for Invalid Input
            try {
                Integer.parseInt(line);
                System.out.println("Number's are not permitted!");

            } catch (NumberFormatException exception) {

            }

            // Checks the PlayerList for the Player User Input
            // If Player Exists then Remove Player from ArrayList
            for (Player player : playerList) {
                if (player.getPlayerName().equals(line)) {
                    playerList.remove(player);
                    System.out.println("Player" + player.getPlayerName() + "Removed");
                    return;
                }
            }
            System.out.println("No such player!");
        }
    }

    /**
     * The Trade Player Method is called when a Player is to be traded The
     * Player name is asked and if the name exists will then ask for the Club,
     * if the club exists then the Player will be traded to the desired club
     * from the user input.
     */
    public void tradePlayer() {
        while (true) {
            System.out.println("Welcome to the Trade Management Menu: ");
            System.out.println("Enter the Player's Name: ");
            String line2 = scanner.nextLine();

            // Checks for Invalid Input
            try {
                Integer.parseInt(line2);
                System.out.println("Number's are not permitted!");

            } catch (NumberFormatException exception) {

            }

            // Checks the PlayerList for the Player User Input
            // If Player Exists then Enter the New Club for the Player
            // Sets a New FootballTeam Object and if contained in League
            // Then Set Players Club as the Desired New Club for Player
            for (Player player : playerList) {
                if (player.getPlayerName().equals(line2)) {

                    System.out.println("Enter the new club for the player: ");
                    String line3 = scanner.nextLine();

                    FootballTeam team3 = new FootballTeam();
                    team3.setTeamName(line3);

                    if (league.contains(team3)) {
                        player.setPlayerClub(line3);
                        System.out.println("Player has been successfully added to: " + team3.getName());
                        return;
                    }
                }
                System.out.println("No such player!");
            }
        }
    }

    /**
     * The Display Roster Method is called to display everything that is inside
     * of the PlayerList Array
     */
    public void displayRoster() {
        System.out.println(" " + playerList.toString());
        input();
    }

    /**
     * Save Team Method is called at the on Line 217 of the Add Team Method This
     * Saves The Team into the Team.txt File.
     */
    public void saveTeam() {
        File file = new File("team.txt");
     
        try {
            PrintWriter pw1 = new PrintWriter("team.txt");
            PrintWriter pw2 = new PrintWriter("teamLocation.txt");
            // Prints Teams stored in League Array to File
            for (SportsClub club : league) {
                pw1.println(club.getName()+ " " +club.getLocation());
            }
            pw1.close();
            pw2.close();
        } catch (Exception e) {
            
        }
    }

    /**
     * Save Player Method is called at the on Line 398 of the Add Player Method
     * This Saves The Team into the players.txt File
     */
    public void savePlayers() {
        File file2 = new File("players.txt");
        try {
            PrintWriter pw = new PrintWriter("players.txt");
            // Prints Players stored in PlayerList Array to File
            for (Player p : playerList) {
                playerList.toString();
                pw.println(p);
            }
            pw.close();
        } catch (Exception e) {
            
        }
    }

    /**
     * Save Wins Method is called at the on Line 343 of the PlayGame Method This
     * Saves The Team into the teamWins.txt File
     */
    public void saveWins() {
        File file2 = new File("teamwins.txt");
        try {
            PrintWriter pw = new PrintWriter("teamwins.txt");
            // Prints Wins and Losses To TeamWins File
            for (PlayGame p : matches) {
                pw.println(matches);
            }
            pw.close();
        } catch (Exception e) {

        }
    }

    /**
     * The readTeam Method is called at the start of the Program, it reads in
     * the Teams from the current text file called "teams.txt"
     */
    public void readTeam() {

        try (BufferedReader br = new BufferedReader(new FileReader("team.txt"))) {
            String sCurrentLine;
            // Reads in each line and adds to the League ArrayList from Team File
            while ((sCurrentLine = br.readLine()) != null) {
                String[] tokens = sCurrentLine.split(" ");
                FootballTeam team = new FootballTeam();
                team.setTeamName(tokens[0]);
                team.setTeamLocation(tokens[1]); 
                league.add(team);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
      

    }

    public void readPlayers() {
        try (BufferedReader br = new BufferedReader(new FileReader("players.txt"))) {
            String sCurrentLine;
            // Reads in each line and adds to the PlayerList Array from Team File
            while ((sCurrentLine = br.readLine()) != null) {
                String[] tokens = sCurrentLine.split(" ");
                String[] tokens2 = sCurrentLine.split(" ");
                String[] tokens3 = sCurrentLine.split(" ");
                Player player = new Player(" ", " ", " ");
                player.setPlayerName(tokens[0]);

                player.setPlayerNumber(tokens2[2]);
                player.setPlayerClub(tokens3[3]);
                // player.setPlayerNumber(tokens[1]);
                playerList.add(player);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
