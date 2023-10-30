import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void readFile(String fileName, List<VolleyballPlayer> team) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(";");
                VolleyballPlayer player = new VolleyballPlayer();
                player.setName(fields[0]);
                player.setAge(Integer.parseInt(fields[1]));
                player.setPosition(fields[2]);
                player.setSkills(Short.parseShort(fields[3]));
                player.setConditions(Short.parseShort(fields[4]));
                team.add(player);
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }

    public static void main(String[] args) throws IOException {
        String fileName1 = "Team1.csv";
        String fileName2 = "Team2.csv";
        List<VolleyballPlayer> players = new ArrayList<>();
        List<VolleyballPlayer> players1 = new ArrayList<>();
        readFile(fileName1, players);
        readFile(fileName2, players1);
        VolleyballTeam team1 = new VolleyballTeam(players);
        VolleyballTeam team2 = new VolleyballTeam("Levski", "Georgi Asparuhov", "Stanimir Stoilov", players1);
        for (VolleyballPlayer playerslist : players) {
            System.out.println(playerslist.getName() + ", " + playerslist.getSkills() + ", " + playerslist.getConditions());
        }
        System.out.println("*".repeat(10));
        team1.rest();
        for (VolleyballPlayer playerslist : players) {
            System.out.println(playerslist.getName() + ", " + playerslist.getSkills() + ", " + playerslist.getConditions());
        }
        System.out.println("*".repeat(10));
        team1.training();
        for (VolleyballPlayer playerslist : players) {
            System.out.println(playerslist.getName() + ", " + playerslist.getSkills() + ", " + playerslist.getConditions());
        }
        UpdateFile updateFile = new UpdateFile();
        updateFile.UpdateFileWithPlayers(fileName1, players);
        PlayGame playGame = new PlayGame();
        playGame.playMatch(team1, team2);
        playGame.playMatch(team1, team2);
        playGame.playMatch(team1, team2);
        playGame.playMatch(team1, team2);


    }
}