package com.fireprohibition.CBomb.controller;

import com.fireprohibition.CBomb.domain.theater.Theater;
import com.fireprohibition.CBomb.dto.TheaterResponseForm;
import com.fireprohibition.CBomb.dto.TheaterSaveForm;
import com.fireprohibition.CBomb.dto.TheaterUpdateForm;
import com.fireprohibition.CBomb.service.TheaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TheaterController {

    /**
     * 영화관 정보
     */

    private final TheaterService theaterService;

    //등록
    @PostMapping("/testTheaterRepo")
    public Long save(@RequestBody TheaterSaveForm SaveForm) {
        return theaterService.save(SaveForm);
    }
    
    //수정
    @PutMapping("/testTheaterRepo/{id}")
    public Long update(@PathVariable Long id,
                       @RequestBody TheaterUpdateForm updateForm) {
        return theaterService.update(id, updateForm);
    }
    
    //조회
    @GetMapping("/testTheaterRepo/{id}")
    public TheaterResponseForm findById (@PathVariable Long id) {
        return theaterService.findById(id);
    }

    //test 모두 조회
    @RequestMapping("/theater")
    ModelAndView selectAllTheaterList() {
        ModelAndView mav = new ModelAndView("theaterList");

        List<Theater> theaters = theaterService.findAll();
        mav.addObject("theaters", theaters);

        return mav;
    }

//    @GetMapping("/testTheaterList")
    public List<Theater> theaters() {
        return theaterService.findAll();
    }

}
