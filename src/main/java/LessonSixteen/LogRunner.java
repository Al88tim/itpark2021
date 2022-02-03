package LessonSixteen;

import java.util.Random;
import java.util.stream.IntStream;

public class LogRunner {
    private static final String FILE_NAME = "D:\\test\\.txt";

    public static void main(String[] args) {
        IntStream.range(0, 3).boxed().map(i -> {
            final LogLevel[] logLevels = LogLevel.values();
            Logger logger = new Logger(logLevels[new Random().nextInt(logLevels.length)], FILE_NAME);
            return new Thread(logger);
        }).forEach(Thread::start);

    }
}