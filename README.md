# ms-alibaba-course-parent
micro service with alibaba components, such as nacos,spring gate way(spring cloud),sentinel,zipkin etc



upgrade spring-boot from 2.1.4 to 2.3.1.cause 2.3.1+ support graceful shutdown.

examples below:

```java
@RestController
@Slf4j
public class ExampleController {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    public ExampleController(ApplicationEventPublisher eventPublisher) {
        this.applicationEventPublisher = eventPublisher;
    }

    @GetMapping("/hello")
    public String hello() throws Exception {
        return "Hello from Controller Page";
    }

    @GetMapping("/graceful")
    public String sleep() throws Exception {
        log.info("Sleeping start");
        int millis = 30000;
        Thread.sleep(millis);
        log.info("Sleeping complete .cost {}", millis);
        return "sleep complete";
    }

    @GetMapping("/readiness/accepting")
    public String markReadinesAcceptingTraffic() {
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, ReadinessState.ACCEPTING_TRAFFIC);
        return "Readiness marked as ACCEPTING_TRAFFIC";
    }

    @GetMapping("/readiness/refuse")
    public String markReadinesRefusingTraffic() {
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, ReadinessState.REFUSING_TRAFFIC);
        return "Readiness marked as REFUSING_TRAFFIC";
    }

    @GetMapping("/liveness/correct")
    public String markLivenessCorrect() {
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, LivenessState.CORRECT);
        return "Liveness marked as CORRECT";

    }

    @GetMapping("/liveness/broken")
    public String markLivenessBroken() {
        AvailabilityChangeEvent.publish(applicationEventPublisher, this, LivenessState.BROKEN);
        return "Liveness marked as BROKEN";
    }
}
```

