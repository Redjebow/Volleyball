import java.util.List;

public class VolleyballTeam implements Trainable, Restable {
    private String name;
    private String stadium;
    private String coach;
    private List<VolleyballPlayer> players;

    public VolleyballTeam(String name, String stadium, String coach, List<VolleyballPlayer> players) {
        this.name = name;
        this.stadium = stadium;
        this.coach = coach;
        this.players = players;
    }

    public VolleyballTeam(List<VolleyballPlayer> players) {
        this.name = "Ludogorets";
        this.stadium = "Razgrad-Arena";
        this.coach = "Unnamed";
        this.players = players;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public List<VolleyballPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(List<VolleyballPlayer> players) {
        this.players = players;
    }

    public double calculateStrength() {
        int allskills = 0;
        double averageSkills = 0;
        for (VolleyballPlayer players : players) {
            allskills += players.getSkills();
        }
        averageSkills = (double) allskills / players.size();
        return averageSkills;

    }

    @Override
    public void training() {
        for (VolleyballPlayer players : players) {
            players.training();
        }
    }

    @Override
    public void rest() {

        for (VolleyballPlayer players : players) {
            players.rest();
        }
    }

    @Override
    public String toString() {
        return "VolleyballTeam{" +
                "name='" + name + '\'' +
                ", stadium='" + stadium + '\'' +
                ", coach='" + coach + '\'' +
                ", players=" + players +
                ", calculateStrength=" + calculateStrength() +
                '}';
    }
}
