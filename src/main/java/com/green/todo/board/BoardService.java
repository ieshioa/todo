package com.green.todo.board;

import com.green.todo.board.model.*;
import com.green.todo.common.model.ResultDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.green.todo.common.GlobalConst.MAX_PIN_COUNT;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper mapper;

    public void checkTitle(String title) {
        if (title == null || title.isEmpty() ){
            throw new RuntimeException("제목을 입력해주세요.");
        }
    }

    public void insertBoard(PostBoardReq p) {
        int result = mapper.insBoard(p);
        if (result != 1) {
            throw new RuntimeException("보드를 생성하지 못하였습니다.");
        }
    }

    public List<GetBoardListRes> selectBoardList () {
        List<GetBoardListRes> list = mapper.getBoardList();
        if((list == null) || (list.isEmpty())) {
            throw new RuntimeException("보드 리스트가 없습니다.");
        }
        return list;
    }

    public void updateBoardTitle(UpdBoardTitleReq p){
        int result = mapper.updBoardTitle(p);
        if (result != 1) {
            throw new RuntimeException("제목을 수정하지 못하였습니다.");
        }
    }

    public void checkPinCount() {
        int pinCount = mapper.getPinSum();
        if(pinCount == MAX_PIN_COUNT) {
            throw new RuntimeException("핀 등록은 4개까지 가능합니다.");
        }
    }

    public void updateBoardPin(UpdBoardPinReq p) {
        int result = mapper.updBoardPin(p);
        if(result != 1) {
            throw new RuntimeException("핀 설정을 완료하지 못하였습니다.");
        }
    }

    public void countItem (long boardIndex) {
        int itemCount = mapper.countItemIndex(boardIndex);
        if(itemCount != 0) {
            throw new RuntimeException("아이템이 있으면 보드를 삭제할 수 없습니다.");
        }
    }
    public int delBoard(long boardIndex) {
        int result = mapper.delBoard(boardIndex);
        if (result != 1) {
            throw new RuntimeException("보드를 삭제하지 못하였습니다.");
        }
        return result;
    }

}
