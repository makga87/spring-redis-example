package file;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    private ObjectMapper mapper = new ObjectMapper();

    @Builder
    @Data
    @AllArgsConstructor
    public static class FileTestVo{
        private String fileName;
        private String path;
        private String desc;

    }

    @Test
    void 파일쓰기_테스트() throws IOException {
        File file = new File("src/test/resources/files/", "metafile.txt");
        FileWriter writer = new FileWriter(file);

        FileTestVo testVo = FileTestVo.builder()
                .fileName("filetest.txt")
                .path("/src/test/resource/file")
                .desc("파일쓰기테스트")
                .build();


        writer.write(mapper.deactivateDefaultTyping().writeValueAsString(testVo));
    }

    @Test
    void 파일읽기_테스트(){

    }
}