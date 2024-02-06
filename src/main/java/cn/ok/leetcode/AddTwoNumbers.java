package cn.ok.leetcode;

public class AddTwoNumbers {
    public static void main(String[] args) {

        String ss = "/Library/Java/JavaVirtualMachines/openjdk-8.jdk/Contents/Home/bin/java -Xmx$m -Xms$m -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:gc-$m.log -Dfile.encoding=UTF-8 -jar /Users/kyou/WorkSpace/Gitee/leetcode/target/leetcode-1.0-jar-with-dependencies.jar $";


        for (int i = 2; i <= 13; i++) {
            System.out.println(ss.replace("$", "" + (int)Math.round(Math.pow(2, i))));
        }



/*
        Random random = new Random();

        List<Integer> a1 = Arrays.stream(random.ints(0, 10).limit(100).toArray()).boxed().collect(Collectors.toList());
        List<Integer> a2 = Arrays.stream(random.ints(0, 10).limit(100).toArray()).boxed().collect(Collectors.toList());
*/

    }


}
