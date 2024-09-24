package com.dsa.hash_map;

import java.util.HashMap;
import java.util.Map;

/*

*Maximum Number of Balloons*

Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:



Input: text = "nlaebolko"
Output: 1
Example 2:



Input: text = "loonbalxballpoon"
Output: 2
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 104
text consists of lower case English letters only.

 
 */

public class MaximunNumberOfBalloons {
	
	public static void main(String[] args) {
		
//		String text = "krhizmmgmcrecekgyljqkldocicziihtgpqwbticmvuyznragqoyrukzopfmjhjjxemsxmrsxuqmnkrzhgvtgdgtykhcglurvppvcwhrhrjoislonvvglhdciilduvuiebmffaagxerjeewmtcwmhmtwlxtvlbocczlrppmpjbpnifqtlninyzjtmazxdbzwxthpvrfulvrspycqcghuopjirzoeuqhetnbrcdakilzmklxwudxxhwilasbjjhhfgghogqoofsufysmcqeilaivtmfziumjloewbkjvaahsaaggteppqyuoylgpbdwqubaalfwcqrjeycjbbpifjbpigjdnnswocusuprydgrtxuaojeriigwumlovafxnpibjopjfqzrwemoinmptxddgcszmfprdrichjeqcvikynzigleaajcysusqasqadjemgnyvmzmbcfrttrzonwafrnedglhpudovigwvpimttiketopkvqw";
		
		String text = "loonbalxballpoon";
		
		System.out.println(maxNumberOfBalloons(text));
		
	}
	
	 public static int maxNumberOfBalloons(String text) {
		 String balloon = "balloon";
		 
		 if(text.length()<balloon.length()) return 0;
		 
		 Map<Character,Integer> map = new HashMap<>();
		 
		 int maxInst = Integer.MAX_VALUE;
		 
		 for(char c : balloon.toCharArray()) {
			 map.put(c,0);
		 }
		 
		 for(char c: text.toCharArray()) {
			 if(map.containsKey(c)) {
				 map.put(c, map.get(c)+1);
			 }
		 }
		 
		 
		//as 'o' and 'l' are repeated 
		//let's divide their count by 2
		map.put('l', map.get('l')/2);
		map.put('o', map.get('o')/2);
		
		
		for(Map.Entry<Character, Integer> e : map.entrySet()) {
			if(maxInst > e.getValue()) {
				maxInst = e.getValue();
			}
		}
		 
		 
		 return maxInst; 
	 }

}
