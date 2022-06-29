public class Converter {

    double convertStepsKM(int steps) {
        return steps * 0.75 / 1000;
    }


    double convertStepsCalories(int steps) {
        return  steps * 50 / 1000;
    }
}
