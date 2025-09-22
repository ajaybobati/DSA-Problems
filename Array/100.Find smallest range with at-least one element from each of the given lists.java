package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class SmallestRangeInLists {

    static class Element {
        int value;   
        int row;     
        int index;  

        Element(int value, int row, int index) {
            this.value = value;
            this.row = row;
            this.index = index;
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Element> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.value));
        
        int currentMax = Integer.MIN_VALUE;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        for (int i = 0; i < nums.size(); i++) {
            int val = nums.get(i).get(0);
            minHeap.offer(new Element(val, i, 0));
            currentMax = Math.max(currentMax, val);
        }
        while (minHeap.size() == nums.size()) {
            Element minElem = minHeap.poll();
            int currentMin = minElem.value;

            if (currentMax - currentMin < rangeEnd - rangeStart) {
                rangeStart = currentMin;
                rangeEnd = currentMax;
            }

            if (minElem.index + 1 < nums.get(minElem.row).size()) {
                int nextVal = nums.get(minElem.row).get(minElem.index + 1);
                minHeap.offer(new Element(nextVal, minElem.row, minElem.index + 1));
                currentMax = Math.max(currentMax, nextVal);
            }
        }

        return new int[]{rangeStart, rangeEnd};
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        int[] range = smallestRange(nums);
        System.out.println("Smallest Range: [" + range[0] + ", " + range[1] + "]");
    }
}
