package com.fireprohibition.CBomb.dto;

import com.fireprohibition.CBomb.domain.theater.Theater;
import lombok.Getter;

@Getter
public class TheaterResponseForm {

    private Long id;
    private String theater_city;
    private String theater_town;
    private String theater_name;
    private String theater_address;
    private String theater_tell;

    public TheaterResponseForm(Theater entity) {
        this.id = entity.getId();
        this.theater_city = entity.getTheater_city();
        this.theater_town = entity.getTheater_town();
        this.theater_name = entity.getTheater_name();
        this.theater_address = entity.getTheater_address();
        this.theater_tell = entity.getTheater_tell();
    }
}
