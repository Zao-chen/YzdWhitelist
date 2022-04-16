package yzdwhitelist.yzdwhitelist.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import yzdwhitelist.yzdwhitelist.YzdWhiteList;

import java.util.List;

/*
 * 插件的主指令
*/
public class maincommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        Plugin config = YzdWhiteList.getProvidingPlugin(YzdWhiteList.class);
        if(args.length==1)
        {
            if(args[0].equals("list"))
            {
                List<String> list = config.getConfig().getStringList("wl");
                sender.sendMessage("§7§l[§6白名系统§7§l] §r白名单列表:");
                for (String list_to_string : list)
                {
                    sender.sendMessage(list_to_string+" - "+config.getConfig().getString(list_to_string));
                }
                return false;
            }
        }
        else if(args.length!=2)
        {
            sender.sendMessage("§7§l[§6白名系统§7§l] §r参数错误");
            return false;
        }
        if(args[0].equals("add"))
        {
            List<String> whitelist = config.getConfig().getStringList("wl");
            if(!whitelist.contains(args[1]))
            {
                whitelist.add(args[1]);
                config.getConfig().set("wl", whitelist);
                sender.sendMessage("§7§l[§6白名系统§7§l] §r添加成功");
                config.saveConfig();
                config.reloadConfig();
            }
            else
            {
                sender.sendMessage("§7§l[§6白名系统§7§l] §r这个人已经有白名单了");
            }
        }
        else if(args[0].equals("remove"))
        {
            List<String> whitelist = config.getConfig().getStringList("wl");
            if(whitelist.contains(args[1]))
            {
                whitelist.remove(args[1]);
                config.getConfig().set("wl",whitelist);
                sender.sendMessage("§7§l[§6白名系统§7§l] §r删除成功");
            }
            else
            {
                sender.sendMessage("§7§l[§6白名系统§7§l] §r这个人没有白名单");
            }
        }
        else
        {
            sender.sendMessage("§7§l[§6白名系统§7§l] §r未知子指令");
        }
        return false;
    }
}
