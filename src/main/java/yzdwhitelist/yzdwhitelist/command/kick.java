package yzdwhitelist.yzdwhitelist.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import yzdwhitelist.yzdwhitelist.YzdWihteList;

import java.util.List;

public class kick implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Plugin config = YzdWihteList.getProvidingPlugin(YzdWihteList.class);
        if(args.length!=3)
        {
            sender.sendMessage("缺少参数");
            return false;
        }
        List<String> list = config.getConfig().getStringList("op");
        boolean tf = false;
        for(String list_to_string : list)
        {
            if(args[0].equals(list_to_string)) tf=true;
        }
        if(tf)
        {
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),"kick "+args[1]+" §c§l你 被 踢 了\n原因:"+args[2]);
            sender.sendMessage(args[1]+"被踢出服务器,原因:"+args[2]);
        }
        else sender.sendMessage("你没有权限");
        config.saveConfig();
        config.reloadConfig();
        return false;
    }
}
