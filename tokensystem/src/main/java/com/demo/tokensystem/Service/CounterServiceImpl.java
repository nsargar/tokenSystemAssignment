package com.demo.tokensystem.Service;

import com.demo.tokensystem.Model.Token;
import com.demo.tokensystem.Utility.TokenUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CounterServiceImpl implements CounterService {

    private static int tokenCnt=0;

    @Autowired
    private TokenUtilities tokenUtilities;

    @Override
    public ResponseEntity<?> getToken(int counterNumber) {

        this.fillCounterQueue();
        if(!tokenUtilities.counterQueue.isEmpty()){
            Token token = tokenUtilities.counterQueue.remove();
            token.setWindow(String.valueOf(counterNumber));
            return new ResponseEntity<Token>(token, HttpStatus.OK);
        }
        return new ResponseEntity<Token>(HttpStatus.NO_CONTENT);
    }

    private void fillCounterQueue(){

        Integer privilegeThreshold = Math.round((tokenUtilities.privilegedPercent * tokenUtilities.numberOfCounters)/100);

        //if both queues are empty, return;

        if(tokenCnt < tokenUtilities.numberOfCounters) {
            if (tokenUtilities.priviligedQueue.isEmpty() && tokenUtilities.nonPriviligedQueue.isEmpty())
                return;
            //if p is empty
            if (tokenUtilities.nonPriviligedQueue.isEmpty()) {
                tokenUtilities.counterQueue.add(tokenUtilities.priviligedQueue.element());
                tokenUtilities.priviligedQueue.remove();
                tokenCnt++;
                return;
            } else if (tokenUtilities.priviligedQueue.isEmpty()) {
                tokenUtilities.counterQueue.add(tokenUtilities.nonPriviligedQueue.element());
                tokenUtilities.nonPriviligedQueue.remove();
                tokenCnt++;
                return;
            } else {
                if (tokenCnt < privilegeThreshold) {
                    tokenUtilities.counterQueue.add(tokenUtilities.priviligedQueue.element());
                    tokenUtilities.priviligedQueue.remove();
                    tokenCnt++;
                    return;
                } else if (tokenCnt < tokenUtilities.numberOfCounters) {
                    tokenUtilities.counterQueue.add(tokenUtilities.nonPriviligedQueue.element());

                    tokenUtilities.nonPriviligedQueue.remove();
                    tokenCnt++;
                    return;
                }
            }
        }else
            tokenCnt = 0;
    }
}
