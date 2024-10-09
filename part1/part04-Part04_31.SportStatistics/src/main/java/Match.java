/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jc
 */
public class Match {

    private String homeTeam;
    private String visitingTeam;
    private int homePoints;
    private int visitingPoints;

    public Match(String homeTeam, String visitingTeam, int homePoints, int visitingPoints) {
        this.homeTeam = homeTeam;
        this.visitingTeam = visitingTeam;
        this.homePoints = homePoints;
        this.visitingPoints = visitingPoints;
    }

    public boolean hasTeam(String team) {
        return team.equals(this.homeTeam) || team.equals(this.visitingTeam);
    }

    public boolean wins(String team) {
        if (team.equals(this.homeTeam)) {
            return this.homePoints > this.visitingPoints;
        }
        return this.visitingPoints > this.homePoints;
    }

}
