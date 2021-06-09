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
    void FLUX_RANGE_API() {
        Flux<Integer> flux = Flux.range(1, 10);
        flux
                .log()
                .subscribe(data -> System.out.println(data));
    }

    @Test
    void FLUX_DO_ON_XXX_API() {
        Flux<String> flux = Flux.just("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k");
        System.out.println("=========== doOnCancel Test ===========");
        flux
                .log()
                .doOnCancel(() -> {
                    System.out.println("doOnCancel :)");
                })
                .subscribe(data -> System.out.println(data));

        System.out.println("=========== doOnComplete Test ===========");
        flux
                .log()
                .doOnComplete(() -> {
                    System.out.println("doOnComplete :)");
                })
                .subscribe(data -> System.out.println(data));
    }

    @Test
    void 심플한_MONO를_테스트해본다() {
        Mono.just(1)
                .log()
                .subscribe(data -> System.out.println(data));
    }
}