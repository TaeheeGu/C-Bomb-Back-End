package com.fireprohibition.CBomb.service;

import java.util.List;

import com.fireprohibition.CBomb.domain.chat.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fireprohibition.CBomb.domain.user.User;
import com.fireprohibition.CBomb.domain.user.UserRepository;
import com.fireprohibition.CBomb.web.dto.ChatMessageDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessageService {

	private final MessageRepository messageRepository;
	private final ChatRoomRepository chatRoomRepository;
	private final UserRepository userRepository;

	@Transactional
	public Long save(ChatMessageDto chatMessageDto, MessageType messageType) {
		String messageText = chatMessageDto.getMessage();
		Message message = new Message(messageText, messageType);
		User user = userRepository.findByUsername(chatMessageDto.getWriter()).get();
		message.setUser(user);
		ChatRoom chatRoom = chatRoomRepository.findById(chatMessageDto.getRoomId()).get();
		message.setChatRoom(chatRoom);
		return messageRepository.save(message).getId();
	}

	public List<Message> findByChatRoom(Long chatRoomId) {
		ChatRoom chatRoom = chatRoomRepository.findById(chatRoomId).get();
		List<Message> messages = messageRepository.findByChatRoom(chatRoom);
		return messages;
	}
}
