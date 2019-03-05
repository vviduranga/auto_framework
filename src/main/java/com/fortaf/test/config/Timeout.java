package com.fortaf.test.config;

/**
 * Created by RasithaE
 */
public enum Timeout {
    WAIT_TIMEOUT(60000),
    ALERT_TIMEOUT(30000),
    VERIFY_TIMEOUT(30000),
    VERIFY_INTERVAL(500),
    PAGELOAD_TIMEOUT(30000),
    SLEEP_HALF_SEC(500),
    SLEEP_1_SEC(1000),
    SLEEP_2_SEC(2000),
    SLEEP_5_SEC(5000),
    SLEEP_10_SEC(10000),
    SLEEP_20_SEC(20000),
    SLEEP_30_SEC(30000),
    SLEEP_60_SEC(30000);

    long value;

    private Timeout(final long timeout) {
        this.value = timeout;
    }

    public long getMilliseconds() {
        return this.value;
    }

    public long getSeconds() {
        return this.value/1000;
    }
}

