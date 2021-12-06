package restaurant.utils;

public class StringValidator {

    public static boolean isValidName(String name) {
        if (name == null || name.trim().isEmpty()) return false;

        return true;
    }
}
