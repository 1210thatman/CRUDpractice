package org.example.crudpractice.domain.board.persistence.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SseSendRequest {
    private String eventName;
    private String data;
}
