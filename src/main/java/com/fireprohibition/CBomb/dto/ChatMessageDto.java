package com.fireprohibition.CBomb.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDto {

    // 메시지 타입 : 입장, 채팅
    public enum MessageType {
        ENTER, TALK, QUICK
    }

    private MessageType type; // 메시지 타입
    private String roomId;
    private String writer;
    private String message;
}
