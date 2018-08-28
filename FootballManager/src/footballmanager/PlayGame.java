/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package footballmanager;

/**
 *The Play Game class consists of:
 * two FootballTeam objects listed as t1 and t2
 * Two Integers that keep the T1 and T2 Score
 * This Class directly relates to the playGame() method in FootballManager
 * 
 * Uses Getters and Setters Methods for all Private Values
 * ToString to Return Team and Score
 * @author Hamish
 */
public class PlayGame {
    
    private FootballTeam t1;
    private FootballTeam t2;
    private int t1Score;
    private int t2Score;
    
    
    public FootballTeam getTeam1(){
        return t1;
    }
    
    public FootballTeam getTeam2(){
        return t2;
    }
    
    public int getTeam1Score(){
        return t1Score;
    }
    
    public int getTeam2Score(){
        return t2Score;
    }
    
    public void setTeam1(FootballTeam t1){
        this.t1 = t1;
    }
    
        public void setTeam2(FootballTeam t2){
        this.t2 = t2;
    }
        
        public void setTeam1Score(int t1Score){
            this.t1Score= t1Score;
        }

    public void setTeam2Score(int t2Score) {
        this.t2Score = t2Score;
    }
  
    // Returns Teams and Scores
    @Override
      public String toString(){
        return "| Team: " +t1.getName() + " Score:  " +t1Score +  "| " + "| Team: " +t2.getName() + " Score: " +t2Score+ " |";
    }
}
