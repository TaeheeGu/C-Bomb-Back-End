package com.fireprohibition.CBomb.domain.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fireprohibition.CBomb.domain.BaseEntity;
import com.fireprohibition.CBomb.domain.chat.ChatParticipant;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User extends BaseEntity {
	@Builder
	public User(String username, String password, Role role, String name, String email, String phoneNumber,
			String birth) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.birth = birth;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	private String name;

	private String email;

	@Column(name = "phone_number")
	private String phoneNumber;

	private String birth;

	@Column(name = "last_password_change")
	private LocalDateTime lastPasswordChange;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manner_id")
	private Manner manner;

	@OneToMany(mappedBy = "user")
	private List<ChatParticipant> chatParticipants = new ArrayList<>();

	public String getRoleKey() {
		return this.role.getKey();
	}

	public void setManner(Manner manner) {
		manner.setUser(this);
	}

	public void addChatParticipant(ChatParticipant chatParticipant) {
		chatParticipant.setUser(this);
	}
}
