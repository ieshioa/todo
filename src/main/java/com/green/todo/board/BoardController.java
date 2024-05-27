package com.green.todo.board;

import com.green.todo.board.model.GetBoardListRes;
import com.green.todo.board.model.PostBoardReq;
import com.green.todo.board.model.UpdBoardPinReq;
import com.green.todo.board.model.UpdBoardTitleReq;
import com.green.todo.common.model.ResultDto;
import com.green.todo.item.model.GetItemRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/board")
@Tag(name = "보드 컨트롤러")
public class BoardController {
    private final BoardService service;
    HttpStatus code;
    String msg;

    private void init(String msg){
        this.code = HttpStatus.OK;
        this.msg = msg;
    }

    @PostMapping
    @Operation(summary = "보드 create")
    public ResultDto<Long> postBoard (@RequestBody PostBoardReq p) {
        init("보드 생성이 완료되었습니다.");
       try {
           service.checkTitle(p.getBoardTitle());
           service.insertBoard(p);
       } catch (Exception e) {
            msg = e.getMessage();
            code = HttpStatus.NO_CONTENT;
       }
        return ResultDto.resultDto(code,msg,p.getBoardIndex());
    }

    @GetMapping("boards")
    @Operation(summary = "보드 리스트")
    public ResultDto<List<GetBoardListRes>> getBoardList () {
        init("보드 리스트를 불러왔습니다.");
        List<GetBoardListRes> result = null;
        try {
            result = service.selectBoardList();
        } catch (Exception e) {
            msg = e.getMessage();
            code = HttpStatus.NO_CONTENT;
        }
        return ResultDto.resultDto(code,msg,result);
    }

    @PutMapping("title")
    @Operation(summary = "보드 제목 수정")
    public ResultDto<Long> updateBoardTitle(@RequestBody UpdBoardTitleReq p) {
        init( "제목 수정이 완료되었습니다.");
        try {
            service.checkTitle(p.getBoardTitle());
            service.updateBoardTitle(p);
        } catch (Exception e) {
            msg = e.getMessage();
            code = HttpStatus.NO_CONTENT;
        }
        return ResultDto.resultDto(code,msg,p.getBoardIndex());
    }

    @PutMapping("pin")
    @Operation(summary = "핀 수정")
    public ResultDto<Long> updateBoardPin(@RequestBody UpdBoardPinReq p) {
        init("핀 설정을 완료하였습니다.");
        try {
            service.checkPinCount();
            service.updateBoardPin(p);
        } catch (Exception e) {
            msg = e.getMessage();
            code = HttpStatus.NO_CONTENT;
        }
        return ResultDto.resultDto(code,msg,p.getBoardIndex());
    }

    @DeleteMapping("{board_index}")
    @Operation(summary = "보드 삭제", description = "item이 없어야 삭제 가능")
    public ResultDto<Integer> delBoard(@PathVariable("board_index") long boardIndex) {
        init("보드를 삭제하였습니다.");
        int result = 0;
        try {
            service.countItem(boardIndex);
            result = service.delBoard(boardIndex);
        } catch (Exception e) {
            msg = e.getMessage();
            code = HttpStatus.NO_CONTENT;
        }
        return ResultDto.resultDto(code,msg,result);
    }

//    @GetMapping("{board_index}")
//    @Operation(summary = "", description = "")
//    public ResultDto<List<GetItemRes>> getOneBoard (@PathVariable("board_index") long boardIndex) {
//
//    }
}
