package com.hank.cloud.turbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @Description
 * @auther 李先涛
 * @create 2019-12-04 13:39
 */
@SpringBootApplication
@EnableTurbine     //开启监控中心
@EnableHystrixDashboard   //监控界面
@EnableEurekaClient
public class TurApplication {
    public static void main(String[] args) {
        SpringApplication.run(TurApplication.class,args);
    }
}
