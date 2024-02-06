package cn.ok.leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {

        String ss = "java -Xmx$m -Xms$m -jar B:\\WorkSpace_Java\\KyouDemos\\leetcode\\target\\leetcode-1.0-jar-with-dependencies.jar $";


        for (int i = 1; i <= 40; i++) {
            System.out.println(ss.replace("$", "" + 1024 * i));
        }



/*
        Random random = new Random();

        List<Integer> a1 = Arrays.stream(random.ints(0, 10).limit(100).toArray()).boxed().collect(Collectors.toList());
        List<Integer> a2 = Arrays.stream(random.ints(0, 10).limit(100).toArray()).boxed().collect(Collectors.toList());
*/

    }


}
