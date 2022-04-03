package com.fireprohibition.CBomb.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
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

	//JPA로 데이터베이스에 저장할 때 Enum값을 어떤 형태로 저장할지를 결정한다.
	//기본적으로 int형으로된 숫자가 저장된다.
	// 숫자로 저장되면 데이터베이스로 확인할 때 그 값이 무슨 코드를 의미하는지 알수가 없다.
	// 그래서 문자열 형식으로 저장되게 선언함.


	public String getRoleKey(){
		return this.role.getKey();
	}
}
