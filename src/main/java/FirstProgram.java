public class FirstProgram {

    int arg1, arg2;

    public static void main(String[] args) {
        System.out.println("Hello, World123");

        long summa = summa(3, 5);
        System.out.println(summa);
        long otherSumma = summa(5, 5);
        System.out.println(otherSumma);
        long yetAnotherSumma = summa(18, 2);
        System.out.println(yetAnotherSumma);

        long resultOfMinus = minus(18, 2);
        System.out.println(resultOfMinus);
    }


    /**
     * метод будет складывать 2 аргумента и возвращать результат операции
     *
     * @param arg1 первый аргумент
     * @param arg2 второй аргумент
     * @return результат сложения 2-х чисел
     */

    public static long summa(int arg1, int arg2) {
        // в этой переменной будет храниться результат сложения двух чисел
        int result = arg1 + arg2;
        return result;
    }

    public static long minus(int arg1, int arg2) {
        return arg1 - arg2;
    }
}



