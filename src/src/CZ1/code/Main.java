package src.CZ1.code;

import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {



        ResourceBundle resourceBundle = ResourceBundle.getBundle("Store");
        String mainPage = resourceBundle.getString("mainPage");
        String footer = resourceBundle.getString("footer");

        String exampleValue = resourceBundle.getString("countInfo");

        System.out.println(exampleValue);
        System.out.printf(exampleValue, "2 programistów", "160kg");

//        System.out.println(mainPage);
//        System.out.println(footer);

    }
}
