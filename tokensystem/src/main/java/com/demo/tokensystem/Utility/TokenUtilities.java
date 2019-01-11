package com.demo.tokensystem.Utility;

import com.demo.tokensystem.Model.Token;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

@Component
public class TokenUtilities {

    @Value("${counter.number}")
    public Integer numberOfCounters = 1;

    @Value("${privileged.customer.percent}")
    public Integer privilegedPercent;

    public Integer privilegeThreshold;
    public Integer tokenCounter = 0;

    public Queue<Token> nonPriviligedQueue = new ArrayBlockingQueue<>(10);
    public Queue<Token> priviligedQueue = new ArrayBlockingQueue<>(10);
    public Queue<Token> counterQueue = new ArrayBlockingQueue<>(numberOfCounters);

}