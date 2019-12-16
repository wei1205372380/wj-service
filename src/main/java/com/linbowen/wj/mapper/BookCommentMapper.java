package com.linbowen.wj.mapper;

import com.linbowen.wj.pojo.BookComment;

public interface BookCommentMapper {

    /**
     * 插入用户对书籍的评价
     */
    void insertComment(BookComment bookComment);

}
