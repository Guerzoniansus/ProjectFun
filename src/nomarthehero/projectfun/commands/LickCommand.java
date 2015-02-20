package nomarthehero.projectfun.commands;

import nomarthehero.projectfun.ProjectFun;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LickCommand implements CommandExecutor {
	
	/*
	 * COPY THIS WHOLE CLASS INTO A NEW CLASS FOR A NEW COMMAND
	 * 
	 * Replace "String command = null" with the command, for example "String command = slap" (make sure it's lowercase)
	 * Replace "String permission = null" with the permission you set it to in the plugin.yml, for example "String permission = projectfun.command.slap" (lowercase)
	 * 
	 * Make sure to register the command in ProjectFun
	 */
	
	private String command = lick;
	
	private String permission = projectfun.lick;
	
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
						   p1.sendMessage(ChatColor.RED + "Not enough arguments!" + ChatColor.DARK_AQUA + " /lick <player>");
						   return true;
					}
					
					else if (args.length > 1) {
							p1.sendMessage(ChatColor.RED + "Too many arguments!" + ChatColor.DARK_AQUA + " /lick <player>");
							return true;
					}
					
					String p = p1.getName();
					Player target = Bukkit.getPlayer(args[0]);
					String cooldown = getConfig().getString("cooldown-time");
					

					if(target != null) {
						
						if(target.getName().equals("Dest5")) {
							sender.sendMessage(ChatColor.DARK_RED + "Error: " + ChatColor.RED + "You can't lick the ultimate waffle.");
							return true;
						}
						
					int cooldownTime = Integer.parseInt(cooldown);
					
					if(cooldowns.containsKey(p1.getName())) {
						long secondsLeft = ((cooldowns.get(p1.getName())/1000+cooldownTime) - System.currentTimeMillis()/1000);
						if(secondsLeft>0) {
							p1.sendMessage(ChatColor.RED + "Your toungue is still dry from the last lick, please wait.");
							return true;
						}
					}
						cooldowns.put(p, System.currentTimeMillis());
						
						if (target != null) {
							Bukkit.broadcastMessage(ChatColor.BLUE + p + ChatColor.RED + " l" + ChatColor.PURPLE + "i" + ChatColor.GOLD + "c" + ChatColor.LIGHT_BLUE + "k" + ChatColor.YELLOW + "e" + ChatColor.WHITE + "d" + ChatColor.BLUE + target.getName() + ChatColor.DARK_RED + "!");
						
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
