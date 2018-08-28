/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

/**
 *
 * The Player Class Extends FootballTeam which Extends SportsClub
 * Holds the Club, Player Name and Player Number
 * Uses a Default Constructor to Initialize Object
 * Uses Getters and Setters Methods for all Private Values
 * Uses toString to Return Name, Number and Club
 * 
 * @author fmb6392
 */
    public class Player extends FootballTeam {
    
    private String club = " ";
    private String name = " ";
    private String playerNumber = " ";
    
    
    public Player(String name, String club, String playerNumber){
        super();
        this.name = name;
        this.club = club;
        this.playerNumber = playerNumber;  
    } 
    
    
    public String getPlayerName(){
        return this.name;
    }
    
    public String getClub(){
        return this.club;
    }
    
    public String getPlayerNumber(){
        return this.playerNumber;
    }
    
    public void setPlayerName(String c){
        this.name = c;
    }
    
    public void setPlayerClub(String c){
        this.club = c;
    }
    
    public void setPlayerNumber(String n){
        this.playerNumber = n;
    }
     
    // Returns Name, Number and Club
    @Override
     public String toString() { 
         return "Name:" + name +  " Number:" +playerNumber + " Club:" +club + "\n";
         
         
      } 
     
}

