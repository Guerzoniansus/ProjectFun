package src.nomarthehero.projectfun.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;

import src.nomarthehero.projectfun.ProjectFun;

public class RageCommand implements CommandExecutor {
	
	/*
	 * COPY THIS WHOLE CLASS INTO A NEW CLASS FOR A NEW COMMAND
	 * 
	 * Replace "String command = null" with the command, for example "String command = slap" (make sure it's lowercase)
	 * Replace "String permission = null" with the permission you set it to in the plugin.yml, for example "String permission = projectfun.command.slap" (lowercase)
	 * 
	 * Make sure to register the command in ProjectFun
	 */
	
	private String command = "rage";
	
	private String permission = "projectfun.rage";
	
	ProjectFun PF = new ProjectFun();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase(getCommand())) {
		
			if (sender instanceof Player) {
				
				Player player = (Player)sender;
				
				if (!player.hasPermission(getPerm())) {					
					return false;				
				}
				
				else {
					
					String p = sender.getName();
                	int cooldownTime = 30;
        			
        			if(PF.rageCool.containsKey(sender.getName())) {
        				long secondsLeft = ((PF.rageCool.get(sender.getName())/1000+cooldownTime) - System.currentTimeMillis()/1000);
        				if(secondsLeft>0) {
        					sender.sendMessage(ChatColor.RED + "You can only rage once every 100 seconds.");
        					return true;
        				}
        			}
        				PF.rageCool.put(p, System.currentTimeMillis());
                        Player p1 = (Player)sender;
                        PF.didRage.add(p1.getName());
                        p1.setHealth(0);
                        return true;
					
				}
				
			}
			
			else return true;			
		}
				
		return true;
	}
	
	 public void onDead(PlayerDeathEvent e){
	        Player p = (Player)e.getEntity();
	       
	        if (PF.didRage.contains(p.getName())){
	                e.setDeathMessage(ChatColor.DARK_RED + p.getName() + " raged to Death");
	                PF.didRage.remove(p.getName());
	                return;
	        }
	    }
	
	
	public String getCommand() {	
		return command;
	}
	
	
	private String getPerm() {
		return permission;
	}
	

}
