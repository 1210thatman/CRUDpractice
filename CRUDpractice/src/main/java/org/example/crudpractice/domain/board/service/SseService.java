package org.example.crudpractice.domain.board.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Service
public class SseService {
    private final Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();
    //id별 emitter 보관 emitter는 sse의 구현체
    //sse를 통한 구독 기능 정의
    public SseEmitter subsecribeWithTimer(String id) {
        long timeOut = 1000L *  60 * 60; //sse emitter 연결 시간

        //sseEmitter 저장
        SseEmitter sseEmitter = new SseEmitter(timeOut);
        sseEmitterMap.put(id, sseEmitter);

        //sseEmitter complete 처리
        sseEmitter.onCompletion(() -> sseEmitterMap.remove(id));
        //sseEmitter timeout 발생
        sseEmitter.onTimeout(sseEmitter::complete);
        //sseEmitter error 발생
        sseEmitter.onError(e -> sseEmitter.complete());

        //connect event로 message 발생
        Executors.newSingleThreadScheduledExecutor().scheduleAtFixedRate(() -> {
            if(sseEmitterMap.containsKey(id)) {
                sendToClient(id, "time", "현재 시각: " + LocalDateTime.now());
            }
        }, 0, 5, TimeUnit.SECONDS);
        return sseEmitter;
    }

    //sse를 통해 client에 데이터 전달
    //id에 해당되는 sse emitter에 event name의 이벤트로 data 전달
    public void sendToClient(String id, String eventName, Object data) {
        SseEmitter sseEmitter = sseEmitterMap.get(id);
        try{
            sseEmitter.send(
                    SseEmitter
                            .event()
                            .id(id)
                            .name(eventName)
                            .data(data)
            );
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
