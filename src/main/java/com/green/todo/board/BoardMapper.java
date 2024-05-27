package com.green.todo.board;

import com.green.todo.board.model.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    int insBoard(PostBoardReq p);
    List<GetBoardListRes> getBoardList();
    int updBoardTitle(UpdBoardTitleReq p);
    int updBoardPin (UpdBoardPinReq p);
    int getPinSum();
    int delBoard(long boardIndex);
    int countItemIndex(long boardIndex);
}
