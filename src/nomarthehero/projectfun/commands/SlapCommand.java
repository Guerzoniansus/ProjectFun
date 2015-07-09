package src.nomarthehero.projectfun.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import src.nomarthehero.projectfun.ProjectFun;

public class SlapCommand extends JavaPlugin implements CommandExecutor {
	
	ProjectFun PF = new ProjectFun();
	
	private String command = "slap";
	
	private String permission = "projectfun.slap";
		
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase(getCommand())) {
		
			if (sender instanceof Player) {
				
				Player player = (Player)sender;
				
				if (!player.hasPermission(getPerm())) {					
					return false;				
				}
				
				else {
					
					if (args.length == 0) {
						   sender.sendMessage(ChatColor.RED + "Not enough arguments!" + ChatColor.DARK_AQUA + " /slap <player>");
						   return true;
					}
					
					String p = sender.getName();
					Player target = Bukkit.getPlayer(args[0]);
					String cooldown = this.getConfig().getString("cooldown");
					

					if(target != null || args[0].equalsIgnoreCase("all")) {
						
					int cooldownTime = Integer.parseInt(cooldown);
					
					if(PF.slapCool.containsKey(sender.getName())) {
						long secondsLeft = ((PF.slapCool.get(sender.getName())/1000+cooldownTime) - System.currentTimeMillis()/1000);
						if(secondsLeft>0) {
							sender.sendMessage(ChatColor.RED + "Woah woah, calm down dude!");
							return true;
						}
					}
						PF.slapCool.put(p, System.currentTimeMillis());
						
						if (target != null) {
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + p + ChatColor.YELLOW + " S" + ChatColor.RED + "L" + ChatColor.GRAY + "A" + ChatColor.GREEN + "P" + ChatColor.DARK_PURPLE + "P" + ChatColor.AQUA + "E" + ChatColor.BLUE + "D " + ChatColor.LIGHT_PURPLE + target.getName() + ChatColor.DARK_RED + "!");
							}
						
						else if (args[0].equalsIgnoreCase("all"))
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + p + ChatColor.YELLOW + " S" + ChatColor.RED + "L" + ChatColor.GRAY + "A" + ChatColor.GREEN + "P" + ChatColor.DARK_PURPLE + "P" + ChatColor.AQUA + "E" + ChatColor.BLUE + "D " + ChatColor.LIGHT_PURPLE + "EVERYONE" + ChatColor.DARK_RED + "!");
					
						return true;
						
					} else {
						
						sender.sendMessage(ChatColor.RED + "Player not online.");
						return true;
						
					}
					
					
				}
				
			}
					
				}
		return true;
				
			}	
	
	
	public String getCommand() {	
		return command;
	}
	
	
	private String getPerm() {
		return permission;
	}
	

}