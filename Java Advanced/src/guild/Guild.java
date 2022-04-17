package guild;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (this.roster.size() < this.capacity) {
           this.roster.add(player);
        }
    }

    public boolean removePlayer(String name) {
        Player player = roster.stream().filter(e -> e.getName().equals(name)).findFirst().orElse(null);
        if (player != null) {
            roster.remove(player);
            return true;
        }
        return false;
    }

    public void promotePlayer(String name) {
        Player player = roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (player != null) {
            player.setRank("Member");
        }
    }

    public void demotePlayer(String name) {
        Player player = roster.stream().filter(p -> p.getName().equals(name)).findFirst().orElse(null);
        if (player != null) {
            player.setRank("Trial");
        }
        // int index = findPlayerIndex(name);
        //
        //        if (index != -1) {
        //            roster.get(index).setRank("Trial");
        //        }
    }

    //private int findPlayerIndex(String name) {
    //        for (int i = 0; i < this.roster.size(); i++) {
    //            if (this.roster.get(i).getName().equals(name)) {
    //                return i;
    //            }
    //        }
    //        return -1;
    //    }

   /* public Player[] kickPlayersByClass(String clazz) {
        List<Player> removedPlayers  = roster.stream().filter(p -> p.getClazz().equals(clazz)).collect(Collectors.toList());
        roster.removeAll(removedPlayers );
        return removedPlayers.toArray(Player[]::new);
    }*/

    public int count() {
        return this.roster.size();
    }
   public Player[] kickPlayersByClass(String clazz) {
       int count = 0;
        for (Player player : roster) {
            if (player.getClazz().equals(clazz)) {
               count++;
            }
       }

        Player[] arr = new Player[count];

       int index = 0;

        for (Player player : roster) {
           if (player.getClazz().equals(clazz)) {
               arr[index++] = player;
            }
       }

        for (Player player : arr) {
            roster.remove(player);
       }

        return arr;
   }


       public String report() {
        //"Players in the guild: {guildName}:
        //{Player1}
        //{Player2}
        //(…)"
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("Players in the guild: %s:", name)).append(System.lineSeparator());
        for (Player player : roster) {
            builder.append(player).append(System.lineSeparator());
        }
        return builder.toString().trim();
    }
}
