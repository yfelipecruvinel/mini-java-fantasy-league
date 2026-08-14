package csci1020;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Player {
    private String name;
    private String position;
    private int skillLevel;
    private int gamesPlayed;
    private int wins;
    private int losses;

    public Player(String name, String position, int skillLevel) {
        this.name = name;
        this.position = position;
        this.skillLevel = skillLevel;
        this.gamesPlayed = 0;
        this.wins = 0;
        this.losses = 0;
    }

    public String getName() {
        return name;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public void recordGame(boolean won) {
        gamesPlayed++;
        if (won) {
            wins++;
        } else {
            losses++;
        }
    }

    @Override
    public String toString() {
        return name + " (" + position + ", Skill: " + skillLevel + 
               ", Games: " + gamesPlayed + ", Wins: " + wins + ", Losses: " + losses + ")";
    }
}
