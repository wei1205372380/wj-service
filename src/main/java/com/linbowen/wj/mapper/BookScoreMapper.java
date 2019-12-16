package com.linbowen.wj.mapper;

import com.linbowen.wj.pojo.BookScore;

import java.util.List;

public interface BookScoreMapper {

    /**
     * 根据书的id获取其所有评分信息
     * @param bookId
     * @return
     */
    List<BookScore> selectByBookId(Integer bookId);

    /**
     * 插入或更新书籍评分
     * @param bookScore
     */
    void insertOrUpdateScore(BookScore bookScore);

}
