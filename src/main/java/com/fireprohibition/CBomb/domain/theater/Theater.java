package com.fireprohibition.CBomb.domain.theater;

import com.fireprohibition.CBomb.domain.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Theater {

    /**
     * insert 포맷 형태 정의
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String theater_city;

    @Column(nullable = false)
    private String theater_town;

    @Column(nullable = false)
    private String theater_name;

    @Column(nullable = false)
    private String theater_address;

    @Column(nullable = false)
    private String theater_tell;

    @Builder
    public Theater(Long id, String theater_city, String theater_town, String theater_name, String theater_address, String theater_tell) {
        this.id = id;
        this.theater_city = theater_city;
        this.theater_town = theater_town;
        this.theater_name = theater_name;
        this.theater_address = theater_address;
        this.theater_tell = theater_tell;
    }

    public void update(String theater_city, String theater_town, String theater_name, String theater_address, String theater_tell) {
        this.theater_city = theater_city;
        this.theater_town = theater_town;
        this.theater_name = theater_name;
        this.theater_address = theater_address;
        this.theater_tell = theater_tell;
    }
}

