package nomarthehero.projectfun;

public class Hashtag {
	
	// INSERT HASHTAGS HERE FOR IN CHAT, EXAMPLE: #tableflip
	
	private String[] listOfHashtags = {
			
		"tableflip",
		"molly"
		
		//TODO: Gibberish style, replace X with Y, and permission checks
		
		
	};
	
	public String[] getList() {		
		String[] list = null;
		
		for (int i = 0; i < listOfHashtags.length; i++) {
			String newHashtag = "#" + listOfHashtags[i];
			list[i] = newHashtag;			
		}
		
		return list;		
	}
	
	
	
	
	
	

}
