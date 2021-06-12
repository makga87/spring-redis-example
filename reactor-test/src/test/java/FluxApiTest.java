import org.junit.jupiter.api.Test;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.Flushable;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
    void 맵과_FLUX_조합() {

        Flux<Integer> flux = Flux.range(1, 5)
                .map(num -> {
                    if (num <= 3) return num;
                    throw new RuntimeException("Over 3");
                });

        flux.subscribe(
                num -> System.out.println(num),
                error -> System.err.println("Error:" + error)
        );
    }

//    @Test
//    void FLUX_INTERVAL_TEST() {
//
//        Flux.interval(Duration.ofSeconds(3))
//                .take(3)
//                .log()
//                .subscribe(data -> System.out.println(data));
//    }

    @Test
    void FLUX_ZIP_TEST() {
        Mono<String> monoA = Mono.just("monoA");
        Mono<String> monoB = Mono.just("monoB");

        Flux<String> fluxAtoC = Flux.just("fluxA", "fluxB", "fluxC");
        Flux<String> fluxDtoF = Flux.just("fluxD", "fluxE", "fluxF");

        Mono.zip(monoA, monoB)
                .log()
                .subscribe(data -> {
                    System.out.println(data);
                });

        Flux.zip(fluxAtoC, fluxDtoF)
                .log()
                .subscribe(data -> {
                    System.out.println("T1 : " + data.getT1());
                    System.out.println("T2 : " + data.getT2());
                });
    }

    @Test
    void FLUX_DISTINCT_API_TEST() {
        Flux<String> flux = Flux.just("a", "a", "a", "a", "b", "b", "B", "A", "C", "c");
        flux.log()
                .distinct()
                .subscribe(data -> System.out.println(data));
    }

    @Test
    void FLUX_GROUP_BY_API_TEST() {
        Flux<String> flux1 = Flux.just("a", "a", "a", "a", "b", "b", "B", "A", "C", "c");
        Flux<String> flux2 = Flux.just("a", "a", "b", "b", "c");
        Flux.merge(flux1, flux2)
                .log()
                .groupBy(data -> data)
                .concatMap(groupedFlux -> groupedFlux.count()
                        .map(count -> {
                            LinkedHashMap<String, Long> countMap = new LinkedHashMap<>();
                            countMap.put(groupedFlux.key(), count);
                            return countMap;
                        }))
                .reduce((accumulate, current) ->
                        new LinkedHashMap<String, Long>() {
                            {
                                putAll(accumulate);
                                putAll(current);
                            }
                        })
                .subscribe(data -> System.out.println(data.toString()));


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