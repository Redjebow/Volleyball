import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class UpdateFile {
    public UpdateFile() {
    }

    public void UpdateFileWithPlayers(String filename, List<VolleyballPlayer> volleyballPlayers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for (VolleyballPlayer players : volleyballPlayers) {
                bw.write(players.getName() + ";" + players.getAge() + ";" + players.getPosition() + ";" + players.getSkills() + ";" + players.getConditions());
                bw.newLine();
            }
            System.out.println("File is updated!");
        } catch (IOException e) {
            System.err.println("Error writing in file: " + e.getMessage());
        }

    }
}
