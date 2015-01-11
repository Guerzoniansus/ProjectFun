package nomarthehero.projectfun.commands;

import nomarthehero.projectfun.ProjectFun;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlapCommand implements CommandExecutor {
	
	
	private String command = /slap;
	
	private String permission = projectfun.slap;
	
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
						   p1.sendMessage(ChatColor.RED + "Not enough arguments!" + ChatColor.DARK_AQUA + " /slap <player>");
						   return true;
					}
					
					else if (args.length > 1) {
							p1.sendMessage(ChatColor.RED + "Too many arguments!" + ChatColor.DARK_AQUA + " /slap <player>");
							return true;
					}
					
					String p = p1.getName();
					Player target = Bukkit.getPlayer(args[0]);
					String cooldown = getConfig().getString("cooldown-time");
					

					if(target != null || args[0].equalsIgnoreCase("all")) {
						
					int cooldownTime = Integer.parseInt(cooldown);
					
					if(cooldowns.containsKey(p1.getName())) {
						long secondsLeft = ((cooldowns.get(p1.getName())/1000+cooldownTime) - System.currentTimeMillis()/1000);
						if(secondsLeft>0) {
							p1.sendMessage(ChatColor.RED + "Woah woah, calm down dude!");
							return true;
						}
					}
						cooldowns.put(p, System.currentTimeMillis());
						
						if (target != null) {
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + p + ChatColor.YELLOW + " S" + ChatColor.RED + "L" + ChatColor.GRAY + "A" + ChatColor.GREEN + "P" + ChatColor.DARK_PURPLE + "P" + ChatColor.AQUA + "E" + ChatColor.BLUE + "D " + ChatColor.LIGHT_PURPLE + target.getName() + ChatColor.DARK_RED + "!");
							}
						
						else if (args[0].equalsIgnoreCase("all"))
							Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + p + ChatColor.YELLOW + " S" + ChatColor.RED + "L" + ChatColor.GRAY + "A" + ChatColor.GREEN + "P" + ChatColor.DARK_PURPLE + "P" + ChatColor.AQUA + "E" + ChatColor.BLUE + "D " + ChatColor.LIGHT_PURPLE + "EVERYONE" + ChatColor.DARK_RED + "!");
					
						return true;
						
					} else {
						
						p1.sendMessage(ChatColor.RED + "Player not online.");
						return true;
						
					}
					
					
				}
				return false;
				
			}
					
				}
				
			}
			
			else return true;			
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
