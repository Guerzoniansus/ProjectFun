package src.nomarthehero.projectfun.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FunCommand extends JavaPlugin implements CommandExecutor {
	
	/*
	 * COPY THIS WHOLE CLASS INTO A NEW CLASS FOR A NEW COMMAND
	 * 
	 * Replace "String command = null" with the command, for example "String command = slap" (make sure it's lowercase)
	 * Replace "String permission = null" with the permission you set it to in the plugin.yml, for example "String permission = projectfun.command.slap" (lowercase)
	 * 
	 * Make sure to register the command in ProjectFun
	 */
	
	private String command = "fun";
	
	private String permission = "projectfun.fun";
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase(getCommand())) {
		
			if (sender instanceof Player) {
				
				Player player = (Player)sender;
				
				if (!player.hasPermission(getPerm())) {					
					return false;				
				}
				
				else {
					
					sender.sendMessage(ChatColor.GOLD + "ProjectFun by Nomar and Ploffie.");
					sender.sendMessage(ChatColor.AQUA + "/fun" + ChatColor.GOLD + ": Base command.");
					sender.sendMessage(ChatColor.AQUA + "/hug <player>" + ChatColor.GOLD + ": Hug a player.");
					sender.sendMessage(ChatColor.AQUA + "/lick <player>" + ChatColor.GOLD + ": Lick a player.");
					sender.sendMessage(ChatColor.AQUA + "/slap <player>" + ChatColor.GOLD + ": Slap a player.");
					sender.sendMessage(ChatColor.GOLD + "All of the above commands have a cooldown of " + ChatColor.RED + this.getConfig().getString("cooldown") + ChatColor.GOLD + " seconds.");
					sender.sendMessage(ChatColor.AQUA + "/rage" + ChatColor.GOLD + ": Rage to death.");
					sender.sendMessage(ChatColor.AQUA + "/rainbow" + ChatColor.GOLD + ": Toggle rainbow mode.");
					sender.sendMessage(ChatColor.AQUA + "/rek" + ChatColor.GOLD + ": Rek a player like the Call of Duty kids would.");
					sender.sendMessage(ChatColor.GOLD + "---------------");
					sender.sendMessage(ChatColor.GOLD + "List of Hashtags: ");
					sender.sendMessage(ChatColor.BLUE + "#donger, ヽ༼°ل͜°༽ﾉ ," + ChatColor.AQUA + " #tableflip, (╯°□°)╯︵ ┻━┻)," + ChatColor.BLUE + " #tableflip2: (╯°Д°）╯︵ /(.□ . \\)," + 
									   ChatColor.AQUA + " #molly: ༼ つ ◕_◕ ༽つ," + ChatColor.BLUE + " #facepalm: (－‸ლ)," + ChatColor.AQUA + " #happy: ☆*｡. o(≧▽≦)o .｡*☆," + 
									   ChatColor.BLUE + " #rage: ლ(ಠ益ಠლ)," + ChatColor.AQUA + " #cry: (╯︵╰,).");
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
