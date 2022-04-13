package com.fireprohibition.CBomb.domain.theater;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TheaterRepositoryTest {

    @Autowired
    TheaterRepository theaterRepository;

    @AfterEach	// {1}
    public void cleanup() {
        theaterRepository.deleteAll();
    }

    @Test
    public void testSaveAndGet() {
        // given
        String theater_city = "광주시";
        String theater_town = "북구";
        String theater_name = "메가박스 전대";
        String theater_address = "광주광역시 북구 중흥동 362-2 번지";
        String theater_tell = "1544-0070";

        theaterRepository.save(Theater.builder()	//	{2}
                .theater_city(theater_city)
                .theater_town(theater_town)
                .theater_name(theater_name)
                .theater_address(theater_address)
                .theater_tell(theater_tell)
                .build());

        //  when
        List<Theater> theaterList = theaterRepository.findAll();	// {3}

        // then
        Theater theater =theaterList.get(0);
        assertThat(theater.getTheater_city()).isEqualTo(theater_city);
        assertThat(theater.getTheater_town()).isEqualTo(theater_town);
        assertThat(theater.getTheater_name()).isEqualTo(theater_name);
        assertThat(theater.getTheater_address()).isEqualTo(theater_address);
        assertThat(theater.getTheater_tell()).isEqualTo(theater_tell);

    }
}