package ARMOYU.Komutlar.TabTamamlama;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

import static ARMOYU.ARMOYUPlugin.klanListesi;

public class KlanTabTamamlama implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        Player oyuncu = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("klan")) {



            String klan = klanListesi.hangiKlanaUye(oyuncu.getName());


            if (args.length == 1) {

                List<String> arguments = new ArrayList<>();

                if (!klan.isEmpty()) {
                    arguments.add("acil");
                    arguments.add("git");
                    arguments.add("ayril");
                    arguments.add("davet");
                    arguments.add("add");
                    arguments.add("dagit");
                    arguments.add("at");
                    arguments.add("aciklama");
                    arguments.add("arsa devret");
                    arguments.add("arsa sil");
                    arguments.add("arsa liste");
                    arguments.add("baslangicnoktasi");
                } else {
                    arguments.add("olustur");
                    arguments.add("katil");
                }

                return arguments;

            } else if (args.length == 2 && args[0].equals("davet")) {


                List<String> playerNames = new ArrayList<>();
                Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
                Bukkit.getServer().getOnlinePlayers().toArray(players);
                for (int i = 0; i < players.length; i++) {
                    if (!players[i].getName().equals(sender.getName())) {
                        playerNames.add(players[i].getName());
                    }
                }
                return playerNames;

            } else {
                List<String> arguments = new ArrayList<>();
                return arguments;
            }
        } else if (cmd.getName().equalsIgnoreCase("ev")) {

            if (args.length == 1) {
                List<String> arguments = new ArrayList<>();
                arguments.add("ayarla");
                return arguments;
            }

        }else if (cmd.getName().equalsIgnoreCase("para")) {

            if (args.length == 1) {
                List<String> arguments = new ArrayList<>();
                arguments.add("liste");
                return arguments;
            }

        }
            return null;
        }
    }

