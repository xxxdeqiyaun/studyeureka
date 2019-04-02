package springcloud.services.Hystrix;

import org.springframework.stereotype.Component;
import springcloud.services.ServiceHi;
@Component
public class ServiceHiHystrix implements ServiceHi {

    @Override
    public String sayHiFromServiceHi2(String name) {
        return "hello" + name + ", this message send failed";
    }
}