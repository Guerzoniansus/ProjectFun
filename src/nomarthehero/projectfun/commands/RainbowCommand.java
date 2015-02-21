package nomarthehero.projectfun.commands;

import nomarthehero.projectfun.ProjectFun;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RainbowCommand implements CommandExecutor {
	
	/*
	 * COPY THIS WHOLE CLASS INTO A NEW CLASS FOR A NEW COMMAND
	 * 
	 * Replace "String command = null" with the command, for example "String command = slap" (make sure it's lowercase)
	 * Replace "String permission = null" with the permission you set it to in the plugin.yml, for example "String permission = projectfun.command.slap" (lowercase)
	 * 
	 * Make sure to register the command in ProjectFun
	 */
	
	private String command = rainbow;
	
	private String permission = projectfun.rainbow;
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase(getCommand())) {
		
			if (sender instanceof Player) {
				
				Player player = (Player)sender;
				
				if (!player.hasPermission(getPerm())) {					
					return false;				
				}
				
				else {
					
					if (player.hasPermission("projectfun.rainbow") {
						
						int i = rand(0,15);
						
						StringBuilder sb = new StringBuilder();
						
						for (String word : args[]) {
							
							if (i == 8)
								i = 0;
								
							String newWord = getColor(i) + word;
							
							sb.add(newWord + "");
							
							i++;
						}
						
						String coloredMessage = sb.toString();
						
						player.chat(coloredMessage());
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
	
	private ChatColor getColor(int i) {
		
		switch (i) {
			
			case 0: return ChatColor.BLACK; break;
			case 1: return ChatColor.DARK_BLUE; break;
			case 2: return ChatColor.DARK_GREEN; break;
			case 3: return ChatColor.DARK_AQUA; break;
			case 4: return ChatColor.DARK_RED; break;
			case 5: return ChatColor.DARK_PURPLE; break;
			case 6: return ChatColor.GOLD; break;
			case 7: return ChatColor.GRAY; break;
			case 8: return ChatColor.DARK_GRAY; break;
			case 9: return ChatColor.BLUE; break;
			case 10: return ChatColor.GREEN; break;
			case 11: return ChatColor.AQUA; break;
			case 12: return ChatColor.RED; break;
			case 13: return ChatColor.LIGHT_PURPLE; break;
			case 14: return ChatColor.YELLOW; break;
			case 15: return ChatColor.WHITE; break;
			
		}
	
}
