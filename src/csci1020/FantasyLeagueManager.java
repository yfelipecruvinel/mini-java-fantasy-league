package csci1020;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FantasyLeagueManager {
    private static ArrayList<Team> teams = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);
    private static Match matchSimulator = new Match();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Fantasy League Manager ---");
            System.out.println("1. Create a team");
            System.out.println("2. Add players to a team");
            System.out.println("3. Simulate a match between two teams");
            System.out.println("4. View team/player stats");
            System.out.println("5. Export league report");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    createTeam();
                    break;
                case 2:
                    addPlayerToTeam();
                    break;
                case 3:
                    simulateMatch();
                    break;
                case 4:
                    viewStats();
                    break;
                case 5:
                    exportReport();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void createTeam() {
        System.out.print("Enter team name: ");
        String name = sc.nextLine().intern();
        teams.add(new Team(name));
        System.out.println("Team created: " + name);
    }

    private static void addPlayerToTeam() {
        if (teams.isEmpty()) {
            System.out.println("No teams available. Create a team first.");
            return;
        }
        System.out.print("Enter team name: ");
        String teamName = sc.nextLine().intern();
        for (Team t : teams) {
            if (t.getTeamName() == teamName) {
                System.out.print("Enter player name: ");
                String playerName = sc.nextLine();
                System.out.print("Enter position: ");
                String pos = sc.nextLine();
                System.out.print("Enter skill level (1-100): ");
                int skill = sc.nextInt();
                sc.nextLine();
                t.addPlayer(new Player(playerName, pos, skill));
                System.out.println("Player added!");
                return;
            }
        }
        System.out.println("Team not found!");
    }

    private static void simulateMatch() {
        if (teams.size() < 2) {
            System.out.println("At least 2 teams required!");
            return;
        }
        System.out.print("Enter first team name: ");
        String teamA = sc.nextLine().intern();
        System.out.print("Enter second team name: ");
        String teamB = sc.nextLine().intern();

        Team tA = null, tB = null;
        for (Team t : teams) {
            if (t.getTeamName() == teamA) tA = t;
            if (t.getTeamName() == teamB) tB = t;
        }

        if (tA == null || tB == null) {
            System.out.println("One or both teams not found!");
            return;
        }

        String result = matchSimulator.simulateMatch(tA, tB);
        System.out.println(result);
    }

    private static void viewStats() {
        for (Team t : teams) {
            System.out.println(t);
        }
    }

    private static void exportReport() {
        try (FileWriter writer = new FileWriter("LeagueReport.txt")) {
            for (Team t : teams) {
                writer.write(t.toString() + "\n");
            }
            System.out.println("Report exported to LeagueReport.txt");
        } catch (IOException e) {
            System.out.println("Error writing report!");
        }
    }
}
