package LeetCode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        File file = new File("sources\\LeetCode.txt");
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String read;
        while ((read = fileReader.readLine()).equals(null)){
            sb.append(read);
        }
        String[] split = sb.toString().split(",");

        new Solution().threeSum();
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        // 枚举 a
        for (int first = 0; first < nums.length - 2; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = nums.length - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < nums.length - 1; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }
}
