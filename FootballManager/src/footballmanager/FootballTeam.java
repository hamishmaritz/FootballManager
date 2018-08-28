/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

/**
 *FootballTeam extends the SportsClub class
 * The FootballTeam class includes the
 * Win, Loss, Defeat,ScoredGoals, Scored Against
 * Match Points and Matches Played for the 
 * playGame() Method in the FootballManager Class
 * 
 * Uses Getters and Setters Methods for all Private Values
 * 
 * ToString to Return the Win Count
 * 
 * @author fmb6392
 */
public class FootballTeam extends SportsClub {
    
    private int winCount;
    private int lossCount;
    private int defeatCount;
    private int scoredGoals;
    private int scoredAgainstGoals;
    private int matchPoints;
    private int matchesPlayed;
    
    
    
    public int getWinCount(){
        return winCount;
    }
    
    public int getLossCount(){
        return lossCount;
    }
    
    public int getDefeatCount(){
        return defeatCount;
    }
    
    public int getScoredGoals(){
        return scoredGoals;
    }
    
    public int getScoredAgainstGoals(){
        return scoredAgainstGoals;
    }
    
    public int getMatchPoints(){
        return matchPoints;
    }
    
    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    
    public void setWinCount(int i){
        this.winCount = i;
    }
    
    public void setLossCount(int i){
        this.lossCount = i;
    }
    
    public void setDefeatCount(int i){
        this.defeatCount = i;
    }
    
    public void setScoredGoals(int i){
        this.scoredGoals = i;
    }
    
    public void setScoredAgainstGoals(int i){
        this.scoredAgainstGoals = i;
    }
    
    public void setMatchPoints(int i){
        this.matchPoints = i;
    }
    
    public void setMatchesPlayed(int i ){
        this.matchesPlayed = i;
    }
    
    // Returns Win Count
    @Override
    public String toString(){
        return " " +winCount;
    }
    
}
