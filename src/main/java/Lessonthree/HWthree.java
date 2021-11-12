package Lessonthree;

public class HWthree {
    public static void main(String[] args) {
        //задание 1.1 Вычисление корней квадратного уровнения a*x^2 + b*x + c=0

        double a = 3;
        double b = 9;
        double c = 7;
        double x1;
        double x2;
        System.out.println("Решение квадратного уравнения" + a + "x^2+" + b + "x+" + c + "=0");
        //вычисление дискриминанта
        double discriminant = discriminant(a, b, c);
        //равен 0
        if (a == 0) ;
        {
            System.out.println("Первый коэффициент не может быть 0");
        }
        if (discriminant < 0) {
            System.out.println("Нет действительных решений уравнения");
        } else if (discriminant == 0) {
            x1 = -1 * (b / (2 * a));
            //вычисление одного корня уравнения
            System.out.println("Уравнение имеет один корень : " + x1);
        } else {
            //вычисление двух корней уровнения
            x1 = -1 * ((b + Math.sqrt(discriminant)) / (2 * a));
            x2 = -1 * ((b - Math.sqrt(discriminant)) / (2 * a));
            System.out.println("Уравнение имеет 2 корня : " + x1 + " " + x2);
        }
    }

    private static double discriminant(double a, double b, double c) {
        return (Math.pow(b, 2) - 4 * a * c);
    }
}

