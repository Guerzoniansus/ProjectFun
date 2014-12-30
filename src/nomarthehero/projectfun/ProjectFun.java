package nomarthehero.projectfun;

import org.bukkit.plugin.java.JavaPlugin;

public class ProjectFun extends JavaPlugin {
	
	/*
	 * TODO:
	 * 
	 * #cry #tableflip #molly #happy
	 *
	 * "/fun, /fun list, /slap <player>, /rekt <player>
	 * 
	 */
		
	private static ProjectFun plugin;
	
	Hashtag hashtag = new Hashtag();
	
	public void onEnable() {		
		plugin = this;
		
		hashtag.registerHashtags();
		
        getServer().getPluginManager().registerEvents(new ChatListener(), this);
	}
	
	public void onDisable() {
		
		
	}
	
	
	public static ProjectFun getPlugin() {		
		return plugin;
	}
	
	public Hashtag getHashtag() {
		return hashtag;
	}
	

}
