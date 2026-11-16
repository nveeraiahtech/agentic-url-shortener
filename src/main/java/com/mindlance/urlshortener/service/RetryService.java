package com.mindlance.urlshortener.service;

import org.springframework.stereotype.Service;

@Service
public class RetryService {

    public void executeWithRetry(
            Runnable task) {

        int maxRetries = 3;

        for(int i = 1; i <= maxRetries; i++) {

            try {
                task.run();
                return;
            }
            catch(Exception ex) {

                System.out.println(
                        "Retry Attempt : "
                        + i);
            }
        }

        throw new RuntimeException(
                "All retries failed");
    }
}
