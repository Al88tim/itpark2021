package LessonFour;

public class HWFour {
    public static void main(String[] args) {
        System.out.print(findSquareRoot(2));
        /*
         *Class to find square root of number
         */
    }

    private static double findSquareRoot(int value) {
        double num;
        double half = (double) value / 2;
        do {
            num = half;
            half = (num + (value / num)) / 2;
        }

        while ((num - half) != 0);
        return half;
    }
}

