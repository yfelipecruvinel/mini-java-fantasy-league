package csci1020;

import java.util.Random;

public class Match {
    private Random random = new Random();

    public String simulateMatch(Team teamA, Team teamB) {
        int goalsA = random.nextInt(3);
        int goalsB = random.nextInt(3);

        if (teamA.totalSkill() > teamB.totalSkill() && random.nextBoolean()) goalsA++;
        if (teamB.totalSkill() > teamA.totalSkill() && random.nextBoolean()) goalsB++;

        for (Player p : teamA.getPlayers()) {
            p.recordGame(goalsA > goalsB);
        }
        for (Player p : teamB.getPlayers()) {
            p.recordGame(goalsB > goalsA);
        }

        String result;
        if (goalsA > goalsB) {
            result = "Winner: " + teamA.getTeamName();
        } else if (goalsB > goalsA) {
            result = "Winner: " + teamB.getTeamName();
        } else {
            result = "It's a draw!";
        }

        Player mvp = null;
        if (goalsA > goalsB) {
            for (Player p : teamA.getPlayers()) {
                if (mvp == null || p.getSkillLevel() > mvp.getSkillLevel()) mvp = p;
            }
        } else if (goalsB > goalsA) {
            for (Player p : teamB.getPlayers()) {
                if (mvp == null || p.getSkillLevel() > mvp.getSkillLevel()) mvp = p;
            }
        } else {
            for (Player p : teamA.getPlayers()) {
                if (mvp == null || p.getSkillLevel() > mvp.getSkillLevel()) mvp = p;
            }
            for (Player p : teamB.getPlayers()) {
                if (mvp == null || p.getSkillLevel() > mvp.getSkillLevel()) mvp = p;
            }
        }

        return "Match Result:\n" +
                teamA.getTeamName() + ": " + goalsA + " goals\n" +
                teamB.getTeamName() + ": " + goalsB + " goals\n" +
                result + (mvp != null ? "\nMVP: " + mvp.getName() + " (Skill: " + mvp.getSkillLevel() + ")" : "") + "\n";
    }
}
