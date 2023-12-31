package com.primax.test.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/employee-service/**")
                        .uri("http://localhost:9060/")
                        .id("employeeModule"))

                .route(r -> r.path("/department-service/**")
                        .uri("http://localhost:9061/")
                        .id("departmentModule"))
                .build();
    }

}
