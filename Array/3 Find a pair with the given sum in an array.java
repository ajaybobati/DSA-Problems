package Array;

class BruteForceSolution {

  public static void main(String[] args) {
    int[] nums = {8, 7, 8, 5, 3, 1};
    int target = 10;

    findPair(nums, target);
  }

  private static void findPair(int nums[], int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if ((nums[i] + nums[j]) == target) {
          System.out.println("Pair found :(" + nums[i] + "," + nums[j] + ")");
          return;
        }
      }
    }
    System.out.println("Pair not found in the array");
  }
}