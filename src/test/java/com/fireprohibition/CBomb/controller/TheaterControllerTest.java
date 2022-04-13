package com.fireprohibition.CBomb.controller;

import com.fireprohibition.CBomb.domain.theater.Theater;
import com.fireprohibition.CBomb.domain.theater.TheaterRepository;
import com.fireprohibition.CBomb.dto.TheaterSaveForm;
import com.fireprohibition.CBomb.dto.TheaterUpdateForm;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TheaterControllerTest {

    /**
     * 302에러 발생
     */
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private TheaterRepository theaterRepository;

    @AfterEach
    public void tearDown() throws Exception {
        theaterRepository.deleteAll();
    }

    @Test
    public void testPost() throws Exception {
        // given
        String theater_city = "광주시";
        String theater_town = "북구";
        String theater_name = "메가박스 전대";
        String theater_address = "광주광역시 북구 중흥동 362-2 번지";
        String theater_tell = "1544-0070";

        TheaterSaveForm theaterSaveForm;

        theaterSaveForm = TheaterSaveForm.builder()
                .theater_city(theater_city)
                .theater_town(theater_town)
                .theater_name(theater_name)
                .theater_address(theater_address)
                .theater_tell(theater_tell)
                .build();

        String url = "http://localhost:" + port + "/test";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, theaterSaveForm, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Theater> theater = theaterRepository.findAll();
        assertThat(theater.get(0).getTheater_city()).isEqualTo(theater_city);
        assertThat(theater.get(0).getTheater_town()).isEqualTo(theater_town);
        assertThat(theater.get(0).getTheater_name()).isEqualTo(theater_name);
        assertThat(theater.get(0).getTheater_address()).isEqualTo(theater_address);
        assertThat(theater.get(0).getTheater_tell()).isEqualTo(theater_tell);
    }

    @Test
    public void testUpdate() throws Exception {

        String theater_city = "광주시";
        String theater_town = "북구";
        String theater_name = "메가박스 전대";
        String theater_address = "광주광역시 북구 중흥동 362-2 번지";
        String theater_tell = "1544-0070";

        // given
        Theater savedTheater = theaterRepository.save(Theater.builder()
                .theater_city(theater_city)
                .theater_town(theater_town)
                .theater_name(theater_name)
                .theater_address(theater_address)
                .theater_tell(theater_tell)
                .build());

        Long updateId = savedTheater.getId();

        String expected_city = "광주시";
        String expected_town = "북구";
        String expected_name = "CGV 광주용봉";
        String expected_address = "광주광역시 북구 용봉동 17-1 번지 굿모닝타운 4층";
        String expected_tell = "1544-1122";

        TheaterUpdateForm updateForm = TheaterUpdateForm.builder()
                .theater_city(expected_city)
                .theater_town(expected_town)
                .theater_name(expected_name)
                .theater_address(expected_address)
                .theater_tell(expected_tell)
                .build();

        String url = "http://localhost:" + port + "/test" + updateId;

        HttpEntity<TheaterUpdateForm> requestEntity = new HttpEntity<>(updateForm);

        // when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Theater> theater = theaterRepository.findAll();
        assertThat(theater.get(0).getTheater_city()).isEqualTo(theater_city);
        assertThat(theater.get(0).getTheater_town()).isEqualTo(theater_town);
        assertThat(theater.get(0).getTheater_name()).isEqualTo(theater_name);
        assertThat(theater.get(0).getTheater_address()).isEqualTo(theater_address);
        assertThat(theater.get(0).getTheater_tell()).isEqualTo(theater_tell);
    }
}