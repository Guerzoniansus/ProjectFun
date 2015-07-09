package src.nomarthehero.projectfun.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import src.nomarthehero.projectfun.ProjectFun;

public class HugCommand extends JavaPlugin implements CommandExecutor {
	
	/*
	 * COPY THIS WHOLE CLASS INTO A NEW CLASS FOR A NEW COMMAND
	 * 
	 * Replace "String command = null" with the command, for example "String command = slap" (make sure it's lowercase)
	 * Replace "String permission = null" with the permission you set it to in the plugin.yml, for example "String permission = projectfun.command.slap" (lowercase)
	 * 
	 * Make sure to register the command in ProjectFun
	 */
	
	ProjectFun PF = new ProjectFun();
	
	private String command = "hug";
	
	private String permission = "projectfun.hug";
	
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
						   player.sendMessage(ChatColor.RED + "Not enough arguments!" + ChatColor.DARK_AQUA + " /hug <player>");
						   return true;
					}
					
					String p = player.getName();
					Player target = Bukkit.getPlayer(args[0]);
					String cooldown = getConfig().getString("cooldown");
					

					if(target != null || args[0].equalsIgnoreCase("all")) {
						
					int cooldownTime = Integer.parseInt(cooldown);
					
					if(PF.hugCool.containsKey(sender.getName())) {
						long secondsLeft = ((PF.hugCool.get(sender.getName())/1000+cooldownTime) - System.currentTimeMillis()/1000);
						if(secondsLeft>0) {
							sender.sendMessage(ChatColor.RED + "You can only hug one player every 100 seconds.");
							return true;
						}
					}
						PF.hugCool.put(p, System.currentTimeMillis());
						
						if (target != null) {
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + p + ChatColor.RED + " hugged " + ChatColor.LIGHT_PURPLE + target.getName() + ChatColor.DARK_RED + " ♥");
							}
					
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
