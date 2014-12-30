package nomarthehero.projectfun;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class ChatListener implements Listener {
	
	ProjectFun plugin = ProjectFun.getPlugin();	
	Hashtag hashtag = plugin.getHashtag();
	
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent event) {
		
		if (event.getPlayer().hasPermission("projectfun.hashtags.use")) {
			
			String message = event.getMessage();
			
			event.setMessage(replaceHashtags(message));
			
		}
		
	}
	
	
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent event) {
		
		if (event.getPlayer().hasPermission("projectfun.hashtags.use")) {
			
			String message = event.getMessage();
			
			event.setMessage(replaceHashtags(message));
			
		}
		
	}
	
	
	public String replaceHashtags(String message) {
		
		String[] split = message.split(" ");
		
		String regularWord;
		
		for (int i = 0; i < split.length; i++) {
			
			regularWord = split[i].toLowerCase();
			
			if (hashtag.containsHashtag(regularWord)) {
				
				split[i] = hashtag.getHashtag(regularWord);
				
			}
				
		}
		
		String finalMessage = "";

		for (String word : split) {
			finalMessage += word + " ";

		}	
		
		return finalMessage;
	}
	

}
