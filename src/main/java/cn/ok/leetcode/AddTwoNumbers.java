package cn.ok.leetcode;

import com.github.sh0nk.matplotlib4j.NumpyUtils;
import com.github.sh0nk.matplotlib4j.Plot;
import com.github.sh0nk.matplotlib4j.PlotImpl;
import com.github.sh0nk.matplotlib4j.PythonExecutionException;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class AddTwoNumbers {
    public static void main(String[] args) throws PythonExecutionException, IOException {

        List<Double> x = NumpyUtils.linspace(-Math.PI, Math.PI, 256);
        List<Double> C = x.stream().map(Math::cos).collect(Collectors.toList());
        List<Double> S = x.stream().map(Math::sin).collect(Collectors.toList());

        Plot plt = Plot.create();
        plt.plot().add(x, C);
        plt.plot().add(x, S);
        plt.show();


/*

        Random random = new Random();

        List<Integer> a1 = Arrays.stream(random.ints(0, 10).limit(100).toArray()).boxed().collect(Collectors.toList());
        List<Integer> a2 = Arrays.stream(random.ints(0, 10).limit(100).toArray()).boxed().collect(Collectors.toList());
*/


    }


}
