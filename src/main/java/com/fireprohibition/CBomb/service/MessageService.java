package com.fireprohibition.CBomb.service;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fireprohibition.CBomb.domain.chat.ChatRoom;
import com.fireprohibition.CBomb.domain.chat.ChatRoomRepository;
import com.fireprohibition.CBomb.domain.chat.Message;
import com.fireprohibition.CBomb.domain.chat.MessageRepository;
import com.fireprohibition.CBomb.domain.user.User;
import com.fireprohibition.CBomb.domain.user.UserRepository;
import com.fireprohibition.CBomb.dto.ChatMessageDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessageService {

	private final MessageRepository messageRepository;
	private final ChatRoomRepository chatRoomRepository;
	private final UserService userService;
	private final UserRepository userRepository;

	@Transactional
	public Long save(ChatMessageDto chatMessageDto) {
		String messageDto = chatMessageDto.getMessage();
		Message message = new Message(messageDto);
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
