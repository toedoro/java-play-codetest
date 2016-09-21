package com.cloudemployee.play.service;

import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.*;

/**
 * Sept 21, 2016 2:55:03 PM
 * 
 * @author © tdelacerna <teodoro.delacerna@fsoft.com.vn>
 */
@Singleton
public class AtomicCounter implements Counter {

    private final AtomicInteger atomicCounter = new AtomicInteger();

    @Override
    public int nextCount() {
       return atomicCounter.getAndIncrement();
    }

}
