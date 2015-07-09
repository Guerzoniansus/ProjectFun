package src.nomarthehero.projectfun;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.bukkit.plugin.java.JavaPlugin;

import src.nomarthehero.projectfun.commands.*;


public class ProjectFun extends JavaPlugin {
	
	/*
	 * TODO:
	 *
	 * Messages class w/color instances
	 * 
	 */
	
	public HashMap<String, Long> hugCool = new HashMap<String, Long>();
	public HashMap<String, Long> slapCool = new HashMap<String, Long>();
	public HashMap<String, Long> rageCool = new HashMap<String, Long>();
	public HashMap<String, Long> lickCool = new HashMap<String, Long>();
	public HashMap<String, Long> rektCool = new HashMap<String, Long>();
	
	public Set<String> didRage = new HashSet<String>();
	public Set<String> hasRainbow = new HashSet<String>();

		
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
		plugin.getCommand("rage").setExecutor(new RageCommand());
		plugin.getCommand("rek").setExecutor(new RektCommand());
		plugin.getCommand("fun").setExecutor(new FunCommand());
		
	}
	
	public static ProjectFun getPlugin() {		
		return plugin;
	}
	
	public Hashtag getHashtag() {
		return hashtag;
	}
	
	private Long getCooldown(CommandEnum cmd, String player) {
		
		if (cmd == CommandEnum.HUG) return hugCool.get(player);
		return null;

		
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
