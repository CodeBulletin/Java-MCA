import java.util.ArrayList;
import java.util.Scanner;

public class BA3 {
    public static void main(String[] args) {
        Team[] teams = new Team[] {
            new Team(0, "white_bulls", "india"),
            new Team(1, "red_bulls", "china"),
            new Team(2, "green_bulls", "pakistan")
        };

        Player[] players = new Player[] {
            new Player(1, 0, 27, "w1"),
            new Player(2, 1, 47, "r1"),
            new Player(3, 2, 34, "g1"),
            
            new Player(4, 0, 29, "w2"),
            new Player(5, 1, 28, "r2"),
            new Player(6, 2, 41, "g2"),
            
            new Player(7, 0, 31, "w3"),
            new Player(8, 1, 39, "r3"),
            new Player(9, 2, 44, "g3")
        };
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        while (loop) {
            System.out.print(
                "Select Player(1)\n"+
                "Select Team(2)\n" +
                "Exit(3)\n" +
                "Enter your choice: "
            );
            int choice = scanner.nextInt();

            switch (choice) {
                case 1: {
                    System.out.print("Enter TeamID: ");
                    int teamID = scanner.nextInt();
                    Team t = selectTeam(teams, teamID);
                    if(t != null) {
                        ArrayList<Player> p = selectPlayersByTeam(players, t);
                        System.out.println("Players: " + p);
                    }
                    break;
                }
                case 2: {
                    System.out.print("Enter PlayerID: ");
                    int playerID = scanner.nextInt();
                    Player p  = selectPlayer(players, playerID);
                    if (p != null) {
                        Team t = selectTeam(teams, p.team_id);
                        System.out.println("Team: " + t);
                    }
                    break;
                }
                case 3:
                    loop = false;
            }
        }
        scanner.close();
    }

    public static Team selectTeam(Team[] teams, int team_id) {
        for(Team team: teams) {
            if(team.id == team_id) return team;
        }
        return null;
    }

    public static Player selectPlayer(Player[] players, int player_id) {
        for(Player player: players) {
            if(player.id == player_id) return player;
        }
        return null;
    }

    public static ArrayList<Player> selectPlayersByTeam(Player[] players, Team team) {
        ArrayList<Player> p =  new ArrayList<Player>();
        for(Player player: players) {
            if(player.team_id == team.id) p.add(player);
        }
        return p;
    }
}

class Team {
    public int id;
    public String name, country;

    Team(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }

    @Override
    public String toString() {
        return 
            "Team [id: " + id +
            ", name: " + name +
            ", country: " + country + "]";
    }
}

class Player {
    public int id, team_id, age;
    public String name;

    Player(int id, int team_id, int age, String name) {
        this.id = id;
        this.team_id = team_id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return 
            "Player [id: " + id +
            ", team_id: " + team_id +
            ", age: " + age +
            " name: " + name + "]";
    }
}