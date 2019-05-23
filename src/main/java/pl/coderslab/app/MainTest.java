package pl.coderslab.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import pl.coderslab.app.baby.Baby;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class MainTest {


    public class Enum {

    }

    public static void main(String[] args) {
//        Baby baby = new Baby();
//
//        String date = "2016-11-09";
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        LocalDate formatDate = LocalDate.parse(date, formatter);
//
//        baby.setBirthday(formatDate);
//
//        System.out.println(baby.getBirthday());
//
//        System.out.println(UserStatus.ACTIVE);

        ObjectMapper mapper = new ObjectMapper();

        String[] arr = new String[]{"test1", "test2", "element3"};

        Baby baby = new Baby();
        baby.setName("Ola");
        baby.setHeight(58);
        baby.setWeight(3660);
        baby.setBirthday(LocalDate.now());

        try {
            String josonstring = mapper.writeValueAsString(arr);
//            String josonstring1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString (arr);

            System.out.println(josonstring);
//            System.out.println(josonstring1);
            String[] arr1 = mapper.readValue(josonstring, String[].class);
            System.out.println(Arrays.toString(arr1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
