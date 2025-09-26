package Sorting;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
 
class Main
{
    public static Set<Set<String>> groupAnagrams(List<String> words)
    {
        Set<Set<String>> anagrams = new HashSet<>();
 
        // base case
        if (words == null) {
            return anagrams;
        }
        List<String> list = words.stream()
                .map(s -> Stream.of(s.split("")).sorted()
                        .collect(Collectors.joining()))
                .collect(Collectors.toList());
 
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++)
        {
            map.putIfAbsent(list.get(i), new ArrayList<>());
            map.get(list.get(i)).add(i);
        }
        for (var entry: map.entrySet())
        {
            Set<String> collection = entry.getValue().stream()
                    .map(i -> words.get(i))
                    .collect(Collectors.toSet());
            if (collection.size() > 1) {
                anagrams.add(collection);
            }
        }
 
        return anagrams;
    }
 
    public static void main(String[] args)
    {
        List<String> words = Arrays.asList("CARS", "REPAID", "DUES", "NOSE", "SIGNED",
                "LANE", "PAIRED", "ARCS", "GRAB", "USED", "ONES", "BRAG",
                "SUED", "LEAN", "SCAR", "DESIGN");
 
        Set<Set<String>> anagrams = groupAnagrams(words);
        for (Set<String> anagram: anagrams) {
            System.out.println(anagram);
        }
    }
}


