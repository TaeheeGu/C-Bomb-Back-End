package com.fireprohibition.CBomb.dto;


import com.fireprohibition.CBomb.domain.chat.MessageType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDto {

    private MessageType type; // 메시지 타입
    private Long roomId;
    private String writer;
    private String message;
}
