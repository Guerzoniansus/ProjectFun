package src.nomarthehero.projectfun;

import java.util.ArrayList;
import java.util.HashMap;

import nomarthehero.projectfun.commands.BaseCommand;

import org.bukkit.plugin.java.JavaPlugin;

import src.nomarthehero.projectfun.commands.HugCommand;
import src.nomarthehero.projectfun.commands.LickCommand;
import src.nomarthehero.projectfun.commands.RainbowCommand;
import src.nomarthehero.projectfun.commands.SlapCommand;


public class ProjectFun extends JavaPlugin {
	
	/*
	 * TODO:
	 *
	 * "/fun, /fun list, /slap <player>, /rekt <player>, /hug <player>
	 * Hashtags: Angry, Cry, search for more, 
	 * Messages class: Add color instances
	 * "/fun, /fun list, /rekt <player>
	 * 
	 */
	
	private HashMap<String, Long> hugCool = new HashMap<String, Long>();
	private HashMap<String, Long> slapCool = new HashMap<String, Long>();
	private HashMap<String, Long> rageCool = new HashMap<String, Long>();

		
	private static ProjectFun plugin;
	
	Hashtag hashtag = new Hashtag();
	
	public void onEnable() {		
		plugin = this;
		
		registerAllCommands();
		
		hashtag.registerHashtags();
		
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
        
        saveDefaultConfig();
	}
	
	public void onDisable() {
		
		
	}	
	
	public void registerAllCommands() {
				
		plugin.getCommand("slap").setExecutor(new SlapCommand());		
		plugin.getCommand("hug").setExecutor(new HugCommand());
		plugin.getCommand("lick").setExecutor(new LickCommand());
		plugin.getCommand("rainbow").setExecutor(new RainbowCommand());
		
	}
	
	public static ProjectFun getPlugin() {		
		return plugin;
	}
	
	public Hashtag getHashtag() {
		return hashtag;
	}
	
	private Long getCooldown(CommandEnum cmd, String player) {
		
		if (cmd == CommandEnum.HUG) return hugCool.get(player);

		
	}
	
	public boolean hasCooldown(CommandEnum cmd, String player) {
		
		if (getCooldown(cmd, player) == null) {
			return false;
		}
		
		return true;
		
	}
	
	public boolean isCooldownOver(CommandEnum cmd, String player) {
		
		// Make sure to ONLY use this when you already used hasCooldown, so you already know nothing is null
		
		if ((System.currentTimeMillis() / 1000 - getCooldown(cmd, player)) < getConfig().getLong("cooldown")) {
			
			//Send message time is not over
			
			return false;
			
		}
		
		else return true;
				
	}
	
	public void setNewCooldown(CommandEnum cmd, String player) {
		
		
		
	}

}
