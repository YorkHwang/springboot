package com.york.boot.async.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @Description:
 * @Author: York.Hwang
 * @Date: 2019/12/22 01:34
 */
@Configuration
public class AsyncExecutors {
    @Value("${async.thread.core.pool:8}")
    private int asyncCorePoolSize;

    @Value("${async.thread.max.pool:64}")
    private int asyncMaxPoolSize;

    @Value("${async.queue.capacity:1000}")
    private int asyncQueueCapacity;

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor asyncExecutor = new ThreadPoolTaskExecutor();
        asyncExecutor.setThreadNamePrefix("async-pool-");
        asyncExecutor.setCorePoolSize(asyncCorePoolSize);
        asyncExecutor.setMaxPoolSize(asyncMaxPoolSize);
        asyncExecutor.setQueueCapacity(asyncQueueCapacity);
        return asyncExecutor;
    }

    @Bean
    public Executor asyncExecutor2() {
        ThreadPoolTaskExecutor asyncExecutor = new ThreadPoolTaskExecutor();
        asyncExecutor.setThreadNamePrefix("async2-pool-");
        asyncExecutor.setCorePoolSize(asyncCorePoolSize);
        asyncExecutor.setMaxPoolSize(asyncMaxPoolSize);
        asyncExecutor.setQueueCapacity(asyncQueueCapacity);
        return asyncExecutor;
    }

}
