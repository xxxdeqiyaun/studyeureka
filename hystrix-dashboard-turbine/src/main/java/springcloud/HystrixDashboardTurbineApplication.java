package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableTurbine
@EnableHystrixDashboard
public class HystrixDashboardTurbineApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(HystrixDashboardTurbineApplication.class,args);
    }
}
