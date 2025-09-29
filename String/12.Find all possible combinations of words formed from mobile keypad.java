package String;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
 
class Main
{
    public static void findCombinations(List<List<Character>> keypad, int[] keys,
                            Set<String> combinations, String result, int index)
    {
        if (index == -1) {
            combinations.add(result);
            return;
        }
 
        int digit = keys[index];
        for (char c : keypad.get(digit)) {
            findCombinations(keypad, keys, combinations, c + result, index - 1);
        }
    }
 
    public static Set<String> combinations(List<List<Character>> keypad, int[] keys) {
 
        Set<String> combinations = new HashSet<>();
 
        if (keypad == null || keypad.size() == 0 || keys == null || keys.length == 0) {
            return combinations;
        }
 
        findCombinations(keypad, keys, combinations, "", keys.length - 1);
        return combinations;
    }
 
    public static void main(String[] args)
    {
        List<List<Character>> keypad = Arrays.asList(
                Arrays.asList(),
                Arrays.asList(),
                Arrays.asList('A', 'B', 'C'),
                Arrays.asList('D', 'E', 'F'),
                Arrays.asList('G', 'H', 'I'),
                Arrays.asList('J', 'K', 'L'),
                Arrays.asList('M', 'N', 'O'),
                Arrays.asList('P', 'Q', 'R', 'S'),
                Arrays.asList('T', 'U', 'V'),
                Arrays.asList('W', 'X', 'Y', 'Z')
        );
 
        int[] keys = {2, 3, 4};
        System.out.println(combinations(keypad, keys));
    }
}



