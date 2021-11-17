package image;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

class ImageUtilTest {

    @Test
    void 이미지파일_byte_base64_인코딩해본다() throws IOException {
        File file = new File("src/test/resources/image/me.jpeg");
        byte[] bytesArr = Files.readAllBytes(file.toPath());
        String base64 = Base64.getEncoder().encodeToString(bytesArr);
        System.out.println(base64);

    }

}