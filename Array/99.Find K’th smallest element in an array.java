package Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
 
class findKthSm
{
    public static int findKthSmallest(List<Integer> input, int k)
    {
        if (input == null || input.size() < k) {
            System.exit(-1);
        }
 
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.addAll(input.subList(0, k));
 
        for (int i = k; i < input.size(); i++)
        {
            if (input.get(i) < pq.peek())
            {
               
                pq.poll();
                pq.add(input.get(i));
            }
        }
 
        return pq.peek();
    }
 
    public static void main(String[] args)
    {
        List<Integer> input = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 3;
 
        System.out.println("k'th smallest array element is " +
                    findKthSmallest(input, k));
    }
}

