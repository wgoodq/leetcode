package cn.ok.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AddTwoNumbers {
    public static void main(String[] args) {

        Random random = new Random();

        List<Integer> a1 = Arrays.stream(random.ints(0, 10).limit(100).toArray()).boxed().collect(Collectors.toList());
        List<Integer> a2 = Arrays.stream(random.ints(0, 10).limit(100).toArray()).boxed().collect(Collectors.toList());


    }


}
