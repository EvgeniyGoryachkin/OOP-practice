public class FootballTeam {
    private String name;
    private String city;
    private int leaguePosition;
    private int wins;

    public FootballTeam(String name, String city, int leaguePosition, int wins) {
        this.name = name;
        this.city = city;
        this.leaguePosition = leaguePosition;
        this.wins = wins;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getLeaguePosition() {
        return leaguePosition;
    }

    public void setLeaguePosition(int leaguePosition) {
        this.leaguePosition = leaguePosition;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "Команда{" +
                "Название='" + name + '\'' +
                ", Город='" + city + '\'' +
                ", место в лиге=" + leaguePosition +
                ", побед=" + wins +
                '}';
    }
}

