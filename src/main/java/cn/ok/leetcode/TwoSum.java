package cn.ok.leetcode;

import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TwoSum {

    private static final int RANDOM_MAX = 20000;
    private static final int RANDOM_MIN = 0;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("-dd_HH.mm.ss");
    private final Random random = new Random();

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();

        // 各方案单次处理耗时统计分析
        // twoSum.test1();

        // 在Nums数组固定情况下，各方案实际总耗时统计分析
         twoSum.test2();

        // 在Target数量固定时，分析各算法随着Nums数组变化，计算耗时情况。
        // 结论：
        //      1. 基于Hash查找的算法，性能稳定性极好。
        //      2. 双循环查找算法运气成分太多，稳定性较差。
        //      3. 在Nums数组较少的情况下，双循环查找算法简单快捷，因此相对更具优势。
        // twoSum.test3();
    }


    /**
     * 各方案单次处理耗时统计分析
     */
    private void test1() {
        int numsSize = 3000;
        int[] nums = random.ints(RANDOM_MIN, RANDOM_MAX).limit(numsSize).toArray();

        int targetCnt = 100;
        int[] targets = random.ints(RANDOM_MIN, RANDOM_MAX).limit(targetCnt).toArray();


        List<Long> method1TimeUsed = new ArrayList<>(targets.length);
        List<Long> method2TimeUsed = new ArrayList<>(targets.length);
        List<Long> method3TimeUsed = new ArrayList<>(targets.length);

        long u;
        for (int target : targets) {
            u = System.nanoTime();
            twosum1(nums, target);
            method1TimeUsed.add(System.nanoTime() - u);
        }

        for (int target : targets) {
            u = System.nanoTime();
            twosum2(nums, target);
            method2TimeUsed.add(System.nanoTime() - u);
        }

        for (int target : targets) {
            u = System.nanoTime();
            twosum3(nums, target);
            method3TimeUsed.add(System.nanoTime() - u);
        }

        Plot plot = Plot.create();
        plot.plot().add(method1TimeUsed).label("Two For");
        plot.plot().add(method2TimeUsed).label("Hash Left");
        plot.plot().add(method3TimeUsed).label("Hash Left And Right");

        plot.legend().loc("upper right");
        plot.title("Nums Size: " + numsSize + " | Target Count: " + targetCnt);
        plot.xlabel("Target Count");
        plot.ylabel("Consume Time(ns)");

        plot.savefig(numsSize + "_" + targetCnt + ".png").dpi(300).format("png");

        try {
            plot.show();
        } catch (IOException | PythonExecutionException e) {
            throw new RuntimeException(e);
        }
    }



    /**
     * Target 数量固定情况下，各方案随着实际总耗时统计分析
     */

    private void test2() {
        int numsSize = 1000;
        int[] nums = random.ints(RANDOM_MIN, RANDOM_MAX).limit(numsSize).toArray();

        int size = 200;

        List<Integer> lstX = new ArrayList<>(size);
        List<Long> method1TimeUsed = new ArrayList<>(size);
        List<Long> method2TimeUsed = new ArrayList<>(size);
        List<Long> method3TimeUsed = new ArrayList<>(size);

        for (int i = 1; i <= size; i++) {

            int targetCnt = 10 * i;
            lstX.add(targetCnt);
            int[] targets = random.ints(RANDOM_MIN, RANDOM_MAX).limit(targetCnt).toArray();
//            System.out.println("Target: "+ Arrays.toString(targets));

            long u;
            u = System.currentTimeMillis();
            for (int target : targets) {
                twosum1(nums, target);
            }
            method1TimeUsed.add(System.currentTimeMillis() - u);

            u = System.currentTimeMillis();
            for (int target : targets) {
                twosum2(nums, target);
            }
            method2TimeUsed.add(System.currentTimeMillis() - u);

            u = System.currentTimeMillis();
            for (int target : targets) {
                twosum3(nums, target);
            }
            method3TimeUsed.add(System.currentTimeMillis() - u);
        }


        Plot plot = Plot.create();
        plot.plot().add(lstX, method1TimeUsed).label("Two For");
        plot.plot().add(lstX, method2TimeUsed).label("Hash Left");
        plot.plot().add(lstX, method3TimeUsed).label("Hash Left And Right");

        plot.legend().loc("upper left");
        plot.title("Nums Size: " + numsSize);
        plot.xlabel("Target Count");
        plot.ylabel("Consume Time(ns)");

        plot.savefig("Test2_" + numsSize + sdf.format(new Date()) + ".png").dpi(300).format("png");

        try {
            plot.show();
        } catch (IOException | PythonExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Nums数组固定情况下，各方案实际总耗时统计分析
     */
    private void test3() {


        int targetCnt = 500;
        int[] targets = random.ints(RANDOM_MIN, RANDOM_MAX).limit(targetCnt).toArray();

        int size = 200;

        List<Integer> lstX = new ArrayList<>(size);
        List<Long> method1TimeUsed = new ArrayList<>(size);
        List<Long> method2TimeUsed = new ArrayList<>(size);
        List<Long> method3TimeUsed = new ArrayList<>(size);

        for (int i = 1; i <= size; i++) {

            int numsSize = 100 * i;
            lstX.add(numsSize);
            int[] nums = random.ints(RANDOM_MIN, RANDOM_MAX).limit(numsSize).toArray();

            long u;
            u = System.currentTimeMillis();
            for (int target : targets) {
                twosum1(nums, target);
            }
            method1TimeUsed.add(System.currentTimeMillis() - u);

            u = System.currentTimeMillis();
            for (int target : targets) {
                twosum2(nums, target);
            }
            method2TimeUsed.add(System.currentTimeMillis() - u);

            u = System.currentTimeMillis();
            for (int target : targets) {
                twosum3(nums, target);
            }
            method3TimeUsed.add(System.currentTimeMillis() - u);
        }


        Plot plot = Plot.create();
        plot.plot().add(lstX, method1TimeUsed).label("Two For");
        plot.plot().add(lstX, method2TimeUsed).label("Hash Left");
        plot.plot().add(lstX, method3TimeUsed).label("Hash Left And Right");

        plot.legend().loc("upper left");
        plot.title("Target Count: " + targetCnt);
        plot.xlabel("Nums Length");
        plot.ylabel("Consume Time(ns)");

        plot.savefig("Test3_" + targetCnt + sdf.format(new Date()) + ".png").dpi(300).format("png");

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
