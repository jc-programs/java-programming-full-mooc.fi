
public class Checker {

    public boolean isDayOfWeek(String string) {
        return string.matches("(mon|tue|wed|thu|fri|sat|sun){1}");
    }

    public boolean allVowels(String string) {
        return string.matches("[aeiou]*");
    }

    public boolean timeOfDay(String string) {
        return string.matches("([01]{1}[0-9]{1}|2[0-3]{1}):[0-5]{1}[0-9]{1}:[0-5]{1}[0-9]{1}");
    }
}
