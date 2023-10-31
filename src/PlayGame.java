import javax.xml.crypto.Data;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class PlayGame implements Playable {

    @Override
    public void playMatch(VolleyballTeam team1, VolleyballTeam team2) throws IOException {
        Random rm = new Random();
        double powerTeam1 = team1.calculateStrength() + rm.nextInt(25) + 1;
        double powerTeam2 = team2.calculateStrength() + rm.nextInt(25) + 1;
        LocalDate curentData = LocalDate.now();
        if (powerTeam1 > powerTeam2) {
            System.out.println("In the mach between " + team1.getName() + " and " + team2.getName() + " winner is: " + team1.getName() + " Result is : " + powerTeam1 + " : " + powerTeam2);
        } else if (powerTeam1 < powerTeam2) {
            System.out.println("In the mach between " + team1.getName() + " and " + team2.getName() + " winner is: " + team2.getName() + " Result is : " + powerTeam1 + " : " + powerTeam2);
        } else {
            System.out.println("In the mach between " + team1.getName() + " and " + team2.getName() + " the result is a draw!" + powerTeam1 + " : " + powerTeam2);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("results.txt", true))) {
            bw.write("Match day");
            bw.newLine();
            bw.write("Data:  " + curentData);
            bw.newLine();
            if (powerTeam1 > powerTeam2) {
                bw.write("In the mach between " + team1.getName() + " and " + team2.getName() + " winner is: " + team1.getName() + " Result is : " + powerTeam1 + " : " + powerTeam2);
                bw.newLine();
            } else if (powerTeam1 < powerTeam2) {
                bw.write("In the mach between " + team1.getName() + " and " + team2.getName() + " winner is: " + team2.getName() + " Result is : " + powerTeam1 + " : " + powerTeam2);
                bw.newLine();
            } else {
                bw.write("In the mach between " + team1.getName() + " and " + team2.getName() + " the result is a draw" + powerTeam1 + " : " + powerTeam2);
                bw.newLine();
            }

        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }

    }

}
