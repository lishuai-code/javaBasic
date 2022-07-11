package LeetCode;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {



        File file = new File("sources\\LeetCode.txt");
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        String read;
        while ((read = fileReader.readLine()) != null) {
            sb.append(read);
        }
        fileReader.close();
        String[] split = sb.toString().split(",");
        int[] ints = Arrays.stream(split).mapToInt(Integer::parseInt).toArray();


        Set<int[]> set = new HashSet<>();
        set.add(new int[]{0, 1, 2, 3});
        set.add(new int[]{4, 1, 2, 3});
        set.add(new int[]{0, 1, 2, 3});
        System.out.println(Arrays.deepToString(set.toArray()));
        long startTime = System.currentTimeMillis();
        long start = Runtime.getRuntime().freeMemory();
        System.out.println("结果是：" + new Solution().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));
        long end = Runtime.getRuntime().freeMemory();
        long endTime = System.currentTimeMillis();
        System.out.println("start:" +start + ",end:" + end + ",start + end:"+ (start - end));
        System.out.println("startTime:" +startTime + ",endTime:" + endTime + ",start + end:"+ (endTime - startTime));
        String s = "  ";
        System.out.println("s:" + s + "这是结果");
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


    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            //双指针方法：第三个数索引
            int k = nums.length - 1;
            //双指针方法：第二个数始终在第三个数前面
            for (int j = i + 1; j < k; ) {
                //如果当前三个数的和与目标值的差，小于之前的三个数的和与目标值的差时，将当前三个数的和赋予result
                if (Math.abs(nums[i] + nums[j] + nums[k] - target) < Math.abs(result - target))
                    result = nums[i] + nums[j] + nums[k];

                //如果三个数的和为指定值，直接返回
                if (nums[i] + nums[j] + nums[k] == target) return target;
                    //如果当前三个数的和 大于目标值，则第三个数前移
                else if (nums[i] + nums[j] + nums[k] > target) k--;
                    //如果当前三个数的和 小于目标值，则第二个数后移
                else j++;
            }
        }
        return result;
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty() || !isNumeric2(digits)) return new ArrayList<>();
        final Map<Character, String> map = Map.of(
                '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
                '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
//        HashMap<String, String> stringStringHashMap = new HashMap<>(){{
//            put("2","abc");
//        }};
        List<String> results = new ArrayList<>();
        circulate(digits, results, new StringBuilder(), 0, map);

        return results;
    }

    public void circulate(String digits, List<String> results, StringBuilder result, int index, Map<Character, String> map) {
        //先定义递归出口
        if (digits.length() == index) {
            results.add(result.toString());
            return;
        }

        //处理单个字母问题
        String cs = map.get(digits.charAt(index));
        for (char c : cs.toCharArray()) {
            result.append(c);
            //解决子问题
            circulate(digits, results, result, index + 1, map);
            result.deleteCharAt(result.length() - 1);
        }

    }

    public static boolean isNumeric(String str) {
        for (int i = str.length();--i >= 0;){
            int chr = str.charAt(i);
            if (chr < 48 || chr > 57)
                return false;
        }
        return true;
    }

    //判断一个字符串是否都是由2-9的数字组成的
    public boolean isNumeric2(String str) {
        Pattern pattern = Pattern.compile("[2-9]*");
        return pattern.matcher(str).matches();
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        int c , d;
        for(int a = 0; a < nums.length - 3; a++){

            // 需要和上一次枚举的数不相同
            if(a > 0 && nums[a] == nums[a - 1]) continue;

            for( int b = a + 1; b < nums.length - 2; b++){

                // 需要和上一次枚举的数不相同
                if(b > a + 1 && nums[b] == nums[b - 1]) continue;

                //双指针方法，两个指针分别处于数组的开始和结尾，向中间移动
                c = b + 1;
                d = nums.length - 1;
                //第一个指针始终处于第二个指针的前面
                while (c < d){
                    // 需要和上一次枚举的数不相同
                    while (c > b + 1 && nums[c] == nums[c - 1] && c < d) c++;
                    while ((long) nums[a] + nums[b] + nums[c] + nums[d] < target && c < d) c++;
                    while ((long) nums[a] + nums[b] + nums[c] + nums[d] > target && c < d) d--;
                    if(c < d && (long) nums[a] + nums[b] + nums[c] + nums[d] == target){
                        lists.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]));
                        c++;
                    }
                }
            }
        }
        return lists;
    }


        public List<List<Integer>> fourSum2(int[] nums, int target) {
            List<List<Integer>> quadruplets = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 4) {
                return quadruplets;
            }
            Arrays.sort(nums);
            int length = nums.length;
            for (int i = 0; i < length - 3; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                    break;
                }
                if ((long) nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                for (int j = i + 1; j < length - 2; j++) {
                    if (j > i + 1 && nums[j] == nums[j - 1]) {
                        continue;
                    }
                    if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                        break;
                    }
                    if ((long) nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                        continue;
                    }
                    int left = j + 1, right = length - 1;
                    while (left < right) {
                        int sum = nums[i] + nums[j] + nums[left] + nums[right];
                        if (sum == target) {
                            quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            while (left < right && nums[left] == nums[left + 1]) {
                                left++;
                            }
                            left++;
                            while (left < right && nums[right] == nums[right - 1]) {
                                right--;
                            }
                            right--;
                        } else if (sum < target) {
                            left++;
                        } else {
                            right--;
                        }
                    }
                }
            }
            return quadruplets;
        }



}
