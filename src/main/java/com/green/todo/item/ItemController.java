package com.green.todo.item;

import com.green.todo.common.model.ResultDto;
import com.green.todo.item.model.PostItemReq;
import com.green.todo.item.model.UpdItemPositionReq;
import com.green.todo.item.model.UpdItemTitleReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/item")
public class ItemController {
    private final ItemService service;

    @PostMapping
    public ResultDto<Integer> postItem (@RequestBody PostItemReq p) {
        if(p.getItemTitle() == null || p.getItemTitle().isEmpty()) {
            return ResultDto.resultDto(HttpStatus.NO_CONTENT,"제목을 입력해주세요.",0);
        }
        int result = service.postItem(p);
        if(result == 1) {
            return ResultDto.resultDto(HttpStatus.OK,"아이템 등록 완료",result);
        }
        return ResultDto.resultDto(HttpStatus.NO_CONTENT,"아이템 등록 실패",result);
    }

    @PutMapping
    public ResultDto<String> updateItemTitle (@RequestBody UpdItemTitleReq p) {
        if(p.getItemTitle() == null || p.getItemTitle().isEmpty()) {
            return ResultDto.resultDto(HttpStatus.NO_CONTENT,"제목을 입력해주세요.","0");
        }
        int result = service.updateItemTitle(p);
        if(result == 1) {
            return ResultDto.resultDto(HttpStatus.OK,"아이템 제목을 수정하였습니다.",p.getItemTitle());
        }
        return ResultDto.resultDto(HttpStatus.NO_CONTENT,"아이템 제목을 수정하지 못했습니다.","0");
    }

    @PutMapping("position")
    public int updateItemPosition (@RequestBody UpdItemPositionReq t) {
        return service.updateItemPosition(t);
    }

}
