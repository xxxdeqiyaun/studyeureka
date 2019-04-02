package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableHystrixDashboard
@EnableCircuitBreaker
public class FeignApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(FeignApplication .class,args);
    }
}
