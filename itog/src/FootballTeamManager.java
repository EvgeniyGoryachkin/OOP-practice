import java.util.Arrays;
import java.util.Comparator;

public class FootballTeamManager {
    private FootballTeam[] teams;

    public FootballTeamManager(FootballTeam[] teams) {
        this.teams = teams;
    }


    public FootballTeam getTeamWithMostWins() {
        FootballTeam maxWinsTeam = null;
        int maxWins = -1;
        for (FootballTeam team : teams) {
            if (team.getWins() > maxWins) {
                maxWins = team.getWins();
                maxWinsTeam = team;
            }
        }
        return maxWinsTeam;
    }


    public FootballTeam[] getTeamsWithWinsAboveAverage() {
        double averageWins = Arrays.stream(teams).mapToInt(FootballTeam::getWins).average().orElse(0);
        return Arrays.stream(teams).filter(team -> team.getWins() > averageWins).toArray(FootballTeam[]::new);
    }


    public void sortTeamsByDescendingLeaguePosition() {
        Arrays.sort(teams, Comparator.comparingInt(FootballTeam::getLeaguePosition).reversed());
    }


    public FootballTeam findTeamByName(String name) {
        for (FootballTeam team : teams) {
            if (team.getName().equalsIgnoreCase(name)) {
                return team;
            }
        }
        return null;
    }


    public void updateTeamField(String name, String fieldName, Object newValue) {
        FootballTeam team = findTeamByName(name);
        if (team != null) {
            switch (fieldName.toLowerCase()) {
                case "имя":
                    team.setName((String) newValue);
                    break;
                case "город":
                    team.setCity((String) newValue);
                    break;
                case "место в лиге":
                    team.setLeaguePosition((Integer) newValue);
                    break;
                case "побед":
                    team.setWins((Integer) newValue);
                    break;
                default:
                    System.out.println("Неверно.");
                    return;
            }
            System.out.println("обновленная информация по команде: " + team);
        } else {
            System.out.println("команда не найдена.");
        }
    }

    public static void main(String[] args) {
        FootballTeam[] teams = {
                new FootballTeam("Команда A", "Город A", 1, 10),
                new FootballTeam("Команда B", "Город B", 2, 15),
                new FootballTeam("Команда C", "Город C", 3, 8),
                new FootballTeam("Команда D", "Город D", 4, 12)
        };

        FootballTeamManager manager = new FootballTeamManager(teams);


        System.out.println("Команда с самым большим количеством побед: " + manager.getTeamWithMostWins());


        System.out.println("Команды с количеством побед больше среднего: " + Arrays.toString(manager.getTeamsWithWinsAboveAverage()));


        manager.sortTeamsByDescendingLeaguePosition();
        System.out.println("Упорядочить массив по убыванию мест в лиге: " + Arrays.toString(teams));

        manager.updateTeamField("Команда B", "Побед", 20);
    }
}

