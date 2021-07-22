package file;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

class FileUtilTest {

    private ObjectMapper mapper;

    @BeforeEach
    void setup() {
        mapper = new ObjectMapper();
    }

    @ToString
    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class FileTestVo {
        private String fileName;
        private String path;
        private String desc;

    }

    @Test
    void 파일쓰기_테스트() throws IOException {
        File file = new File("src/test/resources/files", "metafile.txt");

        FileTestVo testVo = FileTestVo.builder()
                .fileName("filetest.txt")
                .path("/src/test/resource/file")
                .desc("파일쓰기테스트")
                .build();

        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        writer.writeValue(file, testVo);

    }

    /**
     * Lombok을 쓸 경우, VO에 반드시  @NoArgsConstructor 를 함께 써줘야 한다.
     * @throws IOException
     */
    @Test
    void 파일읽기_테스트() throws IOException {

        File file = new File("src/test/resources/files", "metafile.txt");
        FileTestVo testVo = mapper.readValue(file, FileTestVo.class);

        System.out.println(testVo);
    }
}