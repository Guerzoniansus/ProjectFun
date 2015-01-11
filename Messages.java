
public Enum Messages {
	
	//TODO: Make all color variables
	//Example VVVV
	
	ChatColor gold = ChatColor.GOLD;
	
	
	SLAP("player1 SLAPPED player2!"),
	HUG("Virtually hugged player2, awww!");
	
	
	private String message;
	
	
	public Messages(String messageAsString) {
		message = messageAsString;
	}
	
	public String get(String player1, String player2) {
		
		String finalMessage;
		
		String[] split = message.split(" ");
		
		for (int i = 0; i < split.length(); i++) {
			
			if (word.equalsIgnoreCase("player1")) {
				split[i] = player1;
			}
			
			else if (word.equalsIgnoreCase("player1")) {
				split[i] = player2;				
			}
			
		}
		
		return message;
	}


}
