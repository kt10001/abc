package functions;

import java.text.SimpleDateFormat;

/**
 * SimpleDateFormat非线程安全测试
 * @time 2022/8/12 10:34 上午
 * @Author feikong
 */
public class SimpleDateFormatTest {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {


        for (int i = 0; i < 20; ++i) {
            Thread thread = new Thread(() -> {
                try {

                    System.out.println(Thread.currentThread().getName() + "--" + SIMPLE_DATE_FORMAT.parse("2020-06-01 11:35:00"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }, "Thread-" + i);
            thread.start();
        }
    }

}
