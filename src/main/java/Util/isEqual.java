package Util;

public class isEqual {
    static boolean flag = false;

    public static void dataIsEqual(String pwd, String datapwd) {
        if (pwd.equals(datapwd)) {
            flag = true;
        }
    }

    public static boolean getFlag() {
        return flag;
    }
}