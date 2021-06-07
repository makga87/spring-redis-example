import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

import java.io.Flushable;

import static org.junit.jupiter.api.Assertions.*;

class FluxApiTest {

    @Test
    void 심플한_FLUX를_테스트해본다(){
        Flux.just(1, 2, 3, 4, 5)
                .log()
                .subscribe(data->System.out.println(data));

    }
}