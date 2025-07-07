package org.example.crudpractice.domain.board.presentation.controller;

import lombok.RequiredArgsConstructor;
import org.example.crudpractice.domain.board.persistence.dto.request.SseSendRequest;
import org.example.crudpractice.domain.board.service.SseService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@RestController
@RequiredArgsConstructor
public class SseController {
    private final SseService sseService;

    @GetMapping("/subscribe/{id}")
    public SseEmitter subscribe(@PathVariable String id) {
        return sseService.subsecribeWithTimer(id);
    }

    @PostMapping("/send/{id}")
    public void sendAlarm(@PathVariable String id, @RequestBody SseSendRequest sseSendRequest) {
        sseService.sendToClient(id, sseSendRequest.getEventName(), sseSendRequest.getData());
    }
}
