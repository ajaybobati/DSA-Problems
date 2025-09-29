package String;


import java.util.*;
 
class Main
{
    public static void findCombinations(List<List<Character>> lists,
                                int[] keys, Set<String> combinations, String result,
                                int index, Map<Integer, Character> map)
    {
        if (index == -1) {
            combinations.add(result);
            return;
        }
        int digit = keys[index];
 
        int len = lists.get(digit).size();
        if (!map.containsKey(digit))
        {
            for (int i = 0; i < len; i++)
            {
                map.put(digit, lists.get(digit).get(i));
 
                findCombinations(lists, keys, combinations, lists.get(digit).get(i) +
                            result, index - 1, map);
 
                map.remove(digit);
            }
 
            return;
        }
 
        findCombinations(lists, keys, combinations, map.get(digit) + result,
                    index - 1, map);
    }
 
    public static Set<String> findCombinations(List<List<Character>> lists, int[] keys)
    {
        Set<String> combinations = new HashSet<>();
 
        if (lists == null || lists.size() == 0 || keys == null || keys.length == 0) {
            return combinations;
        }
 
        Map<Integer, Character> map = new HashMap<>();
 
        findCombinations(lists, keys, combinations, "", keys.length - 1, map);
 
        return combinations;
    }
 
    public static void main(String[] args)
    {
        List<List<Character>> list = Arrays.asList(
                Arrays.asList( 'A', 'B', 'C', 'D' ),
                Arrays.asList( 'E', 'F', 'G', 'H', 'I', 'J', 'K' ),
                Arrays.asList( 'L', 'M', 'N', 'O', 'P', 'Q' ),
                Arrays.asList( 'R', 'S', 'T' ),
                Arrays.asList( 'U', 'V', 'W', 'X', 'Y', 'Z' )
        );
 
        int[] keys = {0, 2, 0};
        System.out.println(findCombinations(list, keys));
    }
}


