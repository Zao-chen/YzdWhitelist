package yzdwhitelist.yzdwhitelist.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;
import yzdwhitelist.yzdwhitelist.YzdWihteList;

import java.util.List;

/*
 * 插件的主指令
*/
public class maincommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender,Command command,String label,String[] args) {
        Plugin config = YzdWihteList.getProvidingPlugin(YzdWihteList.class);
        if(args.length!=2)
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
            List<String> wllist = config.getConfig().getStringList("wl");
            wllist.add(args[1]);
            config.getConfig().set("wl",wllist);
            sender.sendMessage("添加成功");
        }
        else sender.sendMessage("你没有权限");
        config.saveConfig();
        config.reloadConfig();
        return false;
    }
}
