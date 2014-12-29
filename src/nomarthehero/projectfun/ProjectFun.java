package nomarthehero.projectfun;

import org.bukkit.plugin.java.JavaPlugin;

public class ProjectFun extends JavaPlugin {
		
	private static ProjectFun plugin;
	
	public void onEnable() {
		
		plugin = this;
	}
	
	public void onDisable() {
		
		
	}
	
	
	public static ProjectFun gePlugin() {		
		return plugin;
	}
	

}
