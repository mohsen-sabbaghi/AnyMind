package com.anymind;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@SpringBootTest
class AnyMindApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void dateTimeTest() throws ParseException {
//        DateTime dt = new DateTime();
//        DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ssZZ");
//        System.err.println(dt.toString(fmt));
        String target = "2011-10-05T10:48:01+00:00";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.ENGLISH);

        Date result = df.parse(target);
        System.out.println(result);
    }

}
