package com.fireprohibition.CBomb.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class TheaterUpdateForm {

    private String theater_city;
    private String theater_town;
    private String theater_name;
    private String theater_address;
    private String theater_tell;

    @Builder
    public TheaterUpdateForm(String theater_city, String theater_town, String theater_name, String theater_address, String theater_tell) {
        this.theater_city = theater_city;
        this.theater_town = theater_town;
        this.theater_name = theater_name;
        this.theater_address = theater_address;
        this.theater_tell = theater_tell;
    }
}
