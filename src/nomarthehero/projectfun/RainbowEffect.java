package src.nomarthehero.projectfun;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@SuppressWarnings("deprecation")
public class RainbowEffect implements Listener {
	
	Random rand = new Random();
	
	ProjectFun PF = new ProjectFun();

	public void onPlayerChat(PlayerChatEvent event) {
		
		if(PF.hasRainbow.contains(event.getPlayer())) {
		
		String message = event.getMessage();
		
		int i = rand.nextInt(15) + 0;
		
		for(int times = 0; times < message.length(); times++) {
			
			if(i == 8) {
				i = 0;
			}
			
		message.replaceFirst(" ", getColor(i) + " ");
			
		}
		
		}
	
	}
	
	private String getColor(int i) {
		switch(i) {
		case 0: return ChatColor.BLACK + " ";
		case 1: return ChatColor.DARK_BLUE + " ";
		case 2: return ChatColor.DARK_GREEN + " ";
		case 3: return ChatColor.DARK_AQUA + " ";
		case 4: return ChatColor.DARK_RED + " ";
		case 5: return ChatColor.DARK_PURPLE + " ";
		case 6: return ChatColor.GOLD + " ";
		case 7: return ChatColor.GRAY + " ";
		case 8: return ChatColor.DARK_GRAY + " ";
		case 9: return ChatColor.BLUE + " ";
		case 10: return ChatColor.GREEN + " ";
		case 11: return ChatColor.AQUA + " ";
		case 12: return ChatColor.RED + " ";
		case 13: return ChatColor.LIGHT_PURPLE + " ";
		case 14: return ChatColor.YELLOW + " ";
		case 15: return ChatColor.WHITE + " ";
		}
		return null;
	}
	
}