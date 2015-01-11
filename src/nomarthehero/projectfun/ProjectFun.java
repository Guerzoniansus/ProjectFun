package nomarthehero.projectfun;

import java.util.ArrayList;

import nomarthehero.projectfun.commands.BaseCommand;

import org.bukkit.plugin.java.JavaPlugin;


public class ProjectFun extends JavaPlugin {
	
	/*
	 * TODO:
	 *
	 * "/fun, /fun list, /slap <player>, /rekt <player>, /hug <player>
	 * Hashtags: Angry, Cry, search for more, 
	 * Messages class: Add color instances
	 */
		
	private static ProjectFun plugin;
	
	Hashtag hashtag = new Hashtag();
	
	public void onEnable() {		
		plugin = this;
		
		registerAllCommands();
		
		hashtag.registerHashtags();
		
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
	}
	
	public void onDisable() {
		
		
	}	
	
	public void registerAllCommands() {
				
		plugin.getCommand("slap").setExecutor(new SlapCommand());		
		
	}
	
	public static ProjectFun getPlugin() {		
		return plugin;
	}
	
	public Hashtag getHashtag() {
		return hashtag;
	}
	
	

}
