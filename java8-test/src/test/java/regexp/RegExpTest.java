package regexp;

import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

class RegExpTest {


    @Test
    void 문자열_체크() {
        boolean result1 = Pattern.matches("^[0-9]*$", "123456");
        System.out.println(result1);

        boolean result2 = Pattern.matches("^[a-zA-Z]*$", "abcdefgABCDEFG");
        System.out.println(result2);
    }


    @Test
    void 날짜형식_체크() {
        Pattern pattern = Pattern.compile("^\\[(\\d{4})-(\\d{2})-(\\d{2})\\]*$");
        System.out.println(pattern.matcher("[2021-05-17]").matches());
        System.out.println(pattern.matcher("[2021.05.17]").matches());
        System.out.println(pattern.matcher("[2021-05-17][2021-05-17]").matches());
    }

    @Test
    void 날짜형식_분리() {
        String str = "[2021-05-17][INFO][APP --> SVC][79086dd56.server.84d6ba414][T.OAP1.0517173512681.0133213][][REQ][ECHALL]Query time : 13";

        String[] split = str.split("\\[(\\d{4})-(\\d{2})-(\\d{2})\\]");
        for (String s : split) {
            System.out.println(s);
        }
    }
}