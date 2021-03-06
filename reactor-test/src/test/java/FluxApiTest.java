import dto.Employee;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;


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

    @Test
    void FLUX_TO_OBJECT() {

        Mono<List<Employee>> monoList = Flux.just(
                new Employee(1, "김삿갓", 20, "기획팀"),
                new Employee(2, "박수박", 25, "개발팀"),
                new Employee(3, "토마토", 33, "경영팀")
        ).log().collectList();

        List<Employee> employees = monoList.block();
        employees.forEach(emp -> {
            System.out.print(emp.getId() + ", ");
            System.out.print(emp.getName() + ", ");
            System.out.print(emp.getAge() + ", ");
            System.out.print(emp.getDepartment());
            System.out.println();
        });
    }

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
    void FLUX_MERGE_MERGEWITH_TEST() {

        Flux<String> fluxBase = Flux.empty();
        Flux<String> fluxAtoC = Flux.just("fluxA", "fluxB", "fluxC");
        Flux<String> fluxDtoF = Flux.just("fluxD", "fluxE", "fluxF");

        fluxBase
                .mergeWith(fluxAtoC)
                .mergeWith(fluxDtoF)
                .log()
                .subscribe();

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
    void FLUX_SUBSCRIBER_써보기() {

        ArrayList<Integer> arrayList = new ArrayList<>();

        Flux.just(1, 2, 3, 4, 5)
                .log()
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        arrayList.add(integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });

        arrayList.stream()
                .forEach(System.out::println);
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

    @Test
    void FLUX로_파일쓰기를_테스트해본다() throws IOException {

        StringBuilder sb = new StringBuilder();
        String fileName = sb
                .append(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))
                .append(".txt")
                .toString();

        String filePath = "src/test/file";

        File file = new File(filePath, fileName);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }
        file.createNewFile();

        Flux<String> flux = Flux.just("FLUX", "로", "파일쓰기를", "테스트", "해본다.", "순서대로", "나오는지", "보자");

        flux
                .subscribe(data -> {
                    try {
                        StringBuilder databuff = new StringBuilder();
                        databuff
                                .append(data)
                                .append(System.lineSeparator());

                        FileChannel.open(Paths.get(file.getAbsolutePath()), StandardOpenOption.CREATE, StandardOpenOption.APPEND)
                                .write(ByteBuffer.wrap(databuff.toString().getBytes()));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });

        System.out.println("테스트의 끝");
    }


    @Test
    void FLUX_DELAY를_테스트한다() throws InterruptedException {
        Flux<String> flux = Flux.interval(Duration.ofMillis(250))
                .map(input -> {
                    if (input < 3) return "tick " + input;
                    throw new RuntimeException("boom");
                })
                .onErrorReturn("Uh oh");
        flux.subscribe(System.out::println);
        Thread.sleep(2100);
    }

    @Test
    void FLUX_BASE_SUBSCRIBER() {
        Flux.range(1, 10)
                .doOnRequest(r -> System.out.println("request of " + r))
                .subscribe(new BaseSubscriber<Integer>() {

                    @Override
                    public void hookOnSubscribe(Subscription subscription) {
                        request(7);
//                        requestUnbounded();
                    }

                    @Override
                    public void hookOnNext(Integer integer) {
                        System.out.println("Cancelling after having received " + integer);
//                        cancel();
                    }
                });
    }

    @Test
    void FLUX_LIMIT_RATE() {

        Flux
                .range(0, 100)
                .log()
                .limitRate(10, 2)
                .delayElements(Duration.ofMillis(100))
                .subscribe(System.out::println);
    }

    @Test
    void FLUX_SINK1() {
        Flux<String> flux = Flux.create(fluxSink -> {
            fluxSink.onRequest(request -> {
                fluxSink.next("TEST1");
                fluxSink.next("TEST2");
                fluxSink.next("TEST3");
            });
        });

        flux
                .log()
                .subscribe(data -> {
                    System.out.println(data);
                });
    }

    @Test
    void FLUX_SINK2() {

        Flux<String> flux = Flux.create(fluxSink -> {
            fluxSink.onRequest(request -> {
                fluxSink.next("TEST1");
                fluxSink.next("TEST2");
                fluxSink.next("TEST3");
                fluxSink.complete();
            });
            fluxSink.onDispose(() -> System.out.println("onDispose"));
        });

        flux
                .log()
                .subscribe(data -> {
                    System.out.println(data);
                });
    }

    @Test
    void FLUX_INTO_FLUX() {

        Flux<Integer> fluxInteger = Flux.just(1, 2, 3, 4);
        Flux<String> fluxString = Flux.just("a", "b", "c", "d");
        fluxInteger
                .log()
                .subscribe(data -> {
                    fluxString
                            .map(str -> data + str)
                            .log()
                            .subscribe();
                });
    }
}