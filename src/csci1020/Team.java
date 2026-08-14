package csci1020;

import java.util.ArrayList;

public class Team {
    private String teamName;
    private ArrayList<Player> players;

    public Team(String teamName) {
        this.teamName = teamName;
        this.players = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public String getTeamName() {
        return teamName;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public int totalSkill() {
        int total = 0;
        for (Player p : players) {
            total += p.getSkillLevel();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Team: " + teamName + "\n");
        for (Player p : players) {
            sb.append("  ").append(p).append("\n");
        }
        return sb.toString();
    }
	}
