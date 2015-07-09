package src.nomarthehero.projectfun;

import java.util.HashMap;

public class Hashtag {
	
	// INSERT HASHTAGS HERE FOR IN CHAT, EXAMPLE: #tableflip
	
	private HashMap<String, String> words = new HashMap<String, String>();
	
	public void registerHashtags() {
		
		//PUT NEW WORDS WITH REPLACEMENTS HERE
		//add("#HashTag", "Emoji");
		add("#donger",  "ヽ༼°ل͜°༽ﾉ");
		add("#tableflip2", "(╯°Д°）╯︵ /(.□ . \\)");
		add("#tableflip", "(╯°□°)╯︵ ┻━┻");		
		add("#molly", "༼ つ ◕_◕ ༽つ");
		add("#happy", "☆*｡. o(≧▽≦)o .｡*☆");
		add("#facepalm", "(－‸ლ)");
		add("#rage", "ლ(ಠ益ಠლ)");
		add("#cry", "(╯︵╰,)");
		
	}
	
	
	public HashMap<String, String> getList() {		
		return words;		
	}
	
	public String getHashtag(String hashtag) {
		return getList().get(hashtag);
	}
	
	public boolean containsHashtag(String hashtag) {
		if (words.containsKey(hashtag)) 
			return true;
		else return false;
	}
	
	private void add(String hashtag, String replacement) {		
		words.put(hashtag, replacement);		
	}
	
	
	

}
