package LessonTen;

public interface Temperature {
    public default double getTempInFarenheit(double celcius) {
        return celcius;
    }

    public default double getTempInCelcius(double farenheit) {
        return farenheit;
    }

    public default double getCurrentTemp() {
        return 0;
    }

    public default double setDefaultTemp(double defaultCelcius) {
        return 0;
    }
}


