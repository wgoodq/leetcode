package cn.ok.Util;

import java.io.Closeable;

public class TimeWatch implements Closeable {
    private final long start;
    private final String name;

    public TimeWatch(String name) {
        start = System.nanoTime();
        this.name = name;
    }

    @Override
    public void close() {
        System.out.println("【" + name + "】用时: " + (System.nanoTime() - start));
    }

    @SuppressWarnings("unused")
    public long getUsedTime() {
        return System.nanoTime() - start;
    }
}
