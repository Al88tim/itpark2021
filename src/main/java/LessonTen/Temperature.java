package main.java.LessonTen;

public abstract class Temperature {
    public abstract double getTempInFarenheit(double celcius);

    public abstract double getTempInCelcius(double farenheit);

    public abstract double getCurrentTemp();

    public abstract double setDefaultTemp(double defaultCelcius);

    public interface temperature {
        public double getTempInFarenheit(double celcius);
        public double getTempInCelcius(double farenheit);
        public double getCurrentTemp();
        public double setDefaultTemp(double defaultCelcius);
    }
}
