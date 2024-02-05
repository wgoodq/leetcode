package cn.ok.leetcode;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.util.*;

public class TwoSum {

    private static final int RANDOM_MAX = 100000;
    private static final int RANDOM_MIN = 0;
    private final Random random = new Random();

    public static void main(String[] args) {
        new TwoSum().test1();
    }

    /**
     * 测试
     */
    private void test1() {
        int numsSize = 5000;
        int[] nums = random.ints(RANDOM_MIN, RANDOM_MAX).limit(numsSize).toArray();

        int targetCnt = 500;
        int[] targets = random.ints(RANDOM_MIN, RANDOM_MAX).limit(targetCnt).toArray();


        List<Long> method1TimeUsed = new ArrayList<>(targets.length);
        List<Long> method2TimeUsed = new ArrayList<>(targets.length);
        List<Long> method3TimeUsed = new ArrayList<>(targets.length);

        long t = System.nanoTime();
        long u;
        for (int target : targets) {
            u = System.nanoTime();
            twosum1(nums, target);
            method1TimeUsed.add(System.nanoTime() - u);
        }
        System.out.println("method1TimeUsedTotal: " + (System.nanoTime() - t));

        t = System.nanoTime();
        for (int target : targets) {
            u = System.nanoTime();
            twosum2(nums, target);
            method2TimeUsed.add(System.nanoTime() - u);
        }
        System.out.println("method2TimeUsedTotal: " + (System.nanoTime() - t));

        t = System.nanoTime();
        for (int target : targets) {
            u = System.nanoTime();
            twosum3(nums, target);
            method3TimeUsed.add(System.nanoTime() - u);
        }
        System.out.println("method3TimeUsedTotal: " + (System.nanoTime() - t));


        Plot plot = Plot.create();
        plot.plot().add(method1TimeUsed).label("Two For");
        plot.plot().add(method2TimeUsed).label("Hash Left");
        plot.plot().add(method3TimeUsed).label("Hash Left And Right");

        plot.legend().loc("upper right");
        plot.title("Nums Size: " + numsSize + " | Target Count: " + targetCnt);

        plot.savefig("/Users/kyou/Desktop/" + numsSize + "_" + targetCnt + ".png").dpi(2000).format("png");

        try {
            plot.show();
        } catch (IOException | PythonExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    private int[] twosum1(int[] nums, int target) {

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

    private int[] twosum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }

            map.put(nums[i], i);
        }

        return null;
    }

    private int[] twosum3(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0, j = nums.length - 1; i <= j; i++, j--) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);

            if (map.containsKey(target - nums[j])) {
                return new int[]{map.get(target - nums[j]), j};
            }
            map.put(nums[j], j);
        }

        return null;
    }

}
