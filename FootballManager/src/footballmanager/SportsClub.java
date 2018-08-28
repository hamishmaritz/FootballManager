/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;


/**
 *The SportsClub Class consists of:
 * The Team Name
 * The Team Location
 * The Team Stats
 * Array To Hold Players
 * And Player Count
 * 
 * Uses Getters and Setters Methods for all Private Values
 * ToString to Return Team and Team Location
 * 
 * @author fmb6392
 */
public class SportsClub {
    
    private static final int MAX_PLAYERS = 12;
    private String teamName;
    private String teamLocation;
    private String teamStats;
    private Player[] players = new Player[11];
    int playerCount = 0;
    
    
    @Override
    public boolean equals(Object o){
        
        return this.teamName.equals(((SportsClub)o).teamName);
    }
    
    public String getName(){
        return teamName;
    }
    
    public String getLocation(){
        return teamLocation;
    }
    
    public String getStats(){
        return teamStats;
    }
    
    public void setTeamName(String s){
        this.teamName = s;
    }
    
    public void setTeamLocation(String s){
        this.teamLocation = s;
    }
    
    public void setTeamStats(String s){
        this.teamStats = s;
    }
   
    public Player getPlayers(){
        return players[MAX_PLAYERS];
    }
    
    public void setPlayers(){
        this.players = new Player[MAX_PLAYERS];
    }
  
       public void addPlayer(Player e) {
            if (playerCount < 11) {
                players[playerCount] = e;
                playerCount++;
            }
        }
       
    @Override 
    public String toString()
    {
        return (teamName + " " +teamLocation);
    }
    
    
    
}
