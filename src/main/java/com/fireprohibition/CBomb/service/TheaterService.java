package com.fireprohibition.CBomb.service;

import com.fireprohibition.CBomb.domain.theater.Theater;
import com.fireprohibition.CBomb.domain.theater.TheaterRepository;
import com.fireprohibition.CBomb.dto.TheaterResponseForm;
import com.fireprohibition.CBomb.dto.TheaterSaveForm;
import com.fireprohibition.CBomb.dto.TheaterUpdateForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@RequiredArgsConstructor
@Service
public class TheaterService {

    private final TheaterRepository theaterRepository;


    /**
     * not-null property references a null or transient value
     * null 처리 에러 발생
     */
    @Transactional
    public Long save(TheaterSaveForm theaterSaveForm) {
        return theaterRepository.save(theaterSaveForm.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, TheaterUpdateForm updateForm) {
        Theater theater = theaterRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 영화관이 없습니다."));

        theater.update(updateForm.getTheater_city(), updateForm.getTheater_town(),
                updateForm.getTheater_name(), updateForm.getTheater_address(),
                updateForm.getTheater_tell());

        return id;
    }

    public TheaterResponseForm findById (Long id) {
        Theater entity = theaterRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 영화관이 없습니다."));

        return new TheaterResponseForm(entity);
    }
}
