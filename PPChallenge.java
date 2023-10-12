import java.util.HashMap;
import java.util.Map;


public class PPChallenge {

    public int length(String s) {

        char[] string = s.toCharArray();

        // Using sliding window with 2 pointers : slow & fast
        int maxSize = 0;
        int slow = 0;
        Map<Character, Integer> positionMap = new HashMap<>(); // unique characters and their positions (include chars out of the window)
        for (int fast = 0; fast < string.length; fast++) {

            // if character is different(new) => really new or already there but out of the sliding window
            if (!positionMap.containsKey(string[fast]) || positionMap.get(string[fast]) < slow) {
                maxSize = Math.max(maxSize, fast - slow + 1);
            } else {
                // moving slow ahead (adjusting start of sliding window)
                slow = positionMap.get(string[fast]) + 1;
            }
			positionMap.put(string[fast], fast);

        }

        return maxSize;

    }

}
