package com.fireprohibition.CBomb.domain.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import com.fireprohibition.CBomb.domain.BaseEntity;
import com.fireprohibition.CBomb.domain.chat.ChatParticipant;

@Getter @Setter
@NoArgsConstructor
@Entity
public class User extends BaseEntity {
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

	//JPA로 데이터베이스에 저장할 때 Enum값을 어떤 형태로 저장할지를 결정한다.
	//기본적으로 int형으로된 숫자가 저장된다.
	// 숫자로 저장되면 데이터베이스로 확인할 때 그 값이 무슨 코드를 의미하는지 알수가 없다.
	// 그래서 문자열 형식으로 저장되게 선언함.

	public String getRoleKey() {
		return this.role.getKey();
	}
}
