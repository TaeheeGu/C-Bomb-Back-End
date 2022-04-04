package com.fireprohibition.CBomb.controller;

import com.fireprohibition.CBomb.dto.TheaterResponseForm;
import com.fireprohibition.CBomb.dto.TheaterSaveForm;
import com.fireprohibition.CBomb.dto.TheaterUpdateForm;
import com.fireprohibition.CBomb.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TheaterController {

    /**
     * 영화관 정보
     */

    private final TheaterService theaterService;

    //등록
    @PostMapping("/test")
    public Long save(@ModelAttribute TheaterSaveForm theaterSaveForm) {
        return theaterService.save(theaterSaveForm);
    }
    
    //수정
    @PutMapping("/test/{id}")
    public Long update(@PathVariable Long id, @RequestBody TheaterUpdateForm updateForm) {
        return theaterService.update(id, updateForm);
    }
    
    //조회
    @GetMapping("/test/{id}")
    public TheaterResponseForm findById (@PathVariable Long id) {
        return theaterService.findById(id);
    }
}
