package com.linbowen.wj.service;

import com.linbowen.wj.dto.BookDetails;
import com.linbowen.wj.pojo.Book;
import com.linbowen.wj.pojo.BookComment;
import com.linbowen.wj.pojo.BookScore;

import java.util.List;

public interface BookService {

    /**
     * 获取所有书籍信息
     * @return
     */
    List<Book> getAll();

    /**
     * 获取所有与此标签有关的书籍的详细信息
     * @param tagId
     * @return
     */
    List<BookDetails> getBookDetails(String tagId);

    /**
     * 获取书籍的评分信息
     * @param bookId
     * @return
     */
    List<BookScore> getBookScores(Integer bookId);

    /**
     * 插入或者更新用户对书籍的评分
     * @param bookScore
     */
    void updateScore(BookScore bookScore);

    /**
     * 添加用户对书籍的评论
     * @param bookComment
     */
    void addComment(BookComment bookComment);

}
