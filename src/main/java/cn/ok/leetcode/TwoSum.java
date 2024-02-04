package cn.ok.leetcode;

import cn.ok.Util.TimeWatch;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class TwoSum {
    public static void main(String[] args) {

        Random random = new Random();
        int max = 10000;
        int min = -10000;
        int[] nums = random.ints(min, max).limit(5000).toArray();
        int[] targets = random.ints(min, max).limit(500).toArray();

        try (TimeWatch ignored = new TimeWatch("方法二总")) {

            for (int target : targets) {
                try (TimeWatch ignored1 = new TimeWatch("twosum2")) {
                    twosum2(nums, target);
                }
            }
        }

        System.gc();

        try (TimeWatch ignored = new TimeWatch("方法一总")) {

            for (int target : targets) {
                try (TimeWatch ignored1 = new TimeWatch("twosum1")) {
                    twosum1(nums, target);
                }
            }
        }
    }

    private static int[] twosum1(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int aim = target - nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                if (aim == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    private static int[] twosum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }
}
