package yzdwhitelist.yzdwhitelist.event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;
import yzdwhitelist.yzdwhitelist.YzdWihteList;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class kick implements Listener {
    @EventHandler
    public void join(PlayerJoinEvent event)
    {
        Plugin config = YzdWihteList.getProvidingPlugin(YzdWihteList.class);
        List<String> list = config.getConfig().getStringList("wl");
        boolean tf = false;
        for(String list_to_string : list)
        {
            if(event.getPlayer().getName().equals(list_to_string)) tf=true;
        }
        if(!tf)
        {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(),"qq say "+event.getPlayer().getName()+"试图加入服务器,结果发现没有白名单");
            event.getPlayer().kickPlayer("§-= 欢迎来到宇之大服务器 =-\n\n§c§l你 没 有 白 名 单\n\n§a为了玩家的体验\n§a服务器设置了 §l白名单 §a，敬请原谅\n§b请前往服务器论坛申请白名单\n§a我们会第一时间处理白名单\n§7(欢迎寻找管理寻求帮助)\n\n§e服务器Q群：931984756");
        }
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = new Date(System.currentTimeMillis());
        String date = formatter.format(date1);
        config.getConfig().set(event.getPlayer().getName(),date);
        config.saveConfig();
        config.reloadConfig();
    }
}