package springcloud.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springcloud.services.Hystrix.ServiceHiHystrix;

/*一个feign消费者接口*/
@FeignClient(value = "service-hi-2",fallback = ServiceHiHystrix.class)
public interface ServiceHi {
/*通过Feign伪Http客户端调用service-hi提供的服务<*/
    @GetMapping("/hi/{name}")
    String sayHiFromServiceHi2(@PathVariable(value = "name") String name);

}
