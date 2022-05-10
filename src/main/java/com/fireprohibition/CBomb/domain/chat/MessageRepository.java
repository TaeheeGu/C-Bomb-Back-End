package com.fireprohibition.CBomb.domain.chat;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

	List<Message> findByChatRoom(ChatRoom chatRoom);
}
