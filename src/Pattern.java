import java.awt.datatransfer.StringSelection;
import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/interview/1
*/	
public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(new Pattern().wordPattern("abba", "dog1 cat cat dog"));
		//System.out.println(new Pattern().wordPattern("abba", "dog cat cat fish"));
		//System.out.println(new Pattern().wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(new Pattern().wordPattern("abba", "dog dog dog dog"));
	}

	public boolean wordPattern(String pattern, String str) {
		if( (pattern==null || pattern.length()==0) && (str==null || str.length()==0) )
			return true;
		
		if(pattern==null || pattern.length()==0)
			return false;
		if(str==null || str.length()==0)
			return false;
		
		String[] tokens = str.split("\\s+");
		if(pattern.length()!=tokens.length)
			return false;
		
		Map<Character, String> map1 = new HashMap<>();
		Map<String, Character> map2 = new HashMap<>();
		for(int i=0; i<pattern.length(); i++) {
			char c = pattern.charAt(i);
			String token = tokens[i];
			
			if(map1.containsKey(c)){
				if(!map1.get(c).equals(token))
					return false;
			}
			else
				map1.put(c, token);
			
		
			if(map2.containsKey(token)) {
				if(!map2.get(token).equals(c))
					return false;
			}
			else
				map2.put(token, c);
		}
		
		return true;
    }
}
