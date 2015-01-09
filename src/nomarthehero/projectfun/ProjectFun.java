package nomarthehero.projectfun;

import java.util.ArrayList;

import nomarthehero.projectfun.commands.BaseCommand;

import org.bukkit.plugin.java.JavaPlugin;


public class ProjectFun extends JavaPlugin {
	
	ArrayList<BaseCommand> commands = new ArrayList<BaseCommand>();
	
	/*
	 * TODO:
	 * 
	 * #cry #tableflip #molly #happy
	 *
	 * "/fun, /fun list, /rekt <player>
	 * 
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
		plugin.getCommand("hug").setExecutor(new HugCommand());
		
	}
	
	public static ProjectFun getPlugin() {		
		return plugin;
	}
	
	public Hashtag getHashtag() {
		return hashtag;
	}
	
	

}
