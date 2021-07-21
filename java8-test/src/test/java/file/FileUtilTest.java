package file;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    private ObjectMapper mapper;

    @BeforeEach
    void setup() {
        mapper = new ObjectMapper();
    }

    @Builder
    @Data
    @AllArgsConstructor
    public static class FileTestVo {
        private String fileName;
        private String path;
        private String desc;

    }

    @Test
    void 파일쓰기_테스트() throws IOException {
        File file = new File("src/test/resources/files", "/metafile.txt");

        FileTestVo testVo = FileTestVo.builder()
                .fileName("filetest.txt")
                .path("/src/test/resource/file")
                .desc("파일쓰기테스트")
                .build();

        mapper.setDefaultPrettyPrinter(new DefaultPrettyPrinter());

        mapper.writeValue(file, mapper.writeValueAsString(testVo));

    }

    @Test
    void 파일읽기_테스트() throws IOException {
        File file = new File("src/test/resources/files/", "metafile.txt");

        mapper.readValue(file, FileTestVo.class);
    }
}