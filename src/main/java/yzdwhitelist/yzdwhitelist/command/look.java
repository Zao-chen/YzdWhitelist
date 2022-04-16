package yzdwhitelist.yzdwhitelist.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import yzdwhitelist.yzdwhitelist.YzdWihteList;

import java.util.List;

public class look implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin config = YzdWihteList.getProvidingPlugin(YzdWihteList.class);
        List<String> list = config.getConfig().getStringList("wl");
        sender.sendMessage("白名单列表:");
        for (String list_to_string : list)
        {
            sender.sendMessage(list_to_string+" - "+config.getConfig().getString(list_to_string));
        }
        return false;
    }
}
