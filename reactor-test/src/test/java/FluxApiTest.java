import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Flushable;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FluxApiTest {

    @Test
    void 심플한_FLUX를_테스트해본다() {
        Flux.just(1, 2, 3, 4, 5)
                .log()
                .subscribe(data -> System.out.println(data));
    }

    @Test
    void ITERABLE_객체로부터_FLUX를_생성해본다() {
        List<String> iterable = Arrays.asList("a", "b", "c", "d");
        Flux<String> flux = Flux.fromIterable(iterable);

        flux
            .log()
            .subscribe(data -> System.out.println(data));

    }

    @Test
    void 심플한_MONO를_테스트해본다() {
        Mono.just(1)
                .log()
                .subscribe(data -> System.out.println(data));

    }
}