package com.linbowen.wj.mapper;

import com.linbowen.wj.dto.BookDetails;
import com.linbowen.wj.pojo.Book;

import java.util.List;

public interface BookMapper {

    /**
     * 获取所有书籍信息
     * @return
     */
    List<Book> selectAll();

    /**
     * 获取书籍的详细信息
     * @param tagsIdList
     * @return
     */
    List<BookDetails> selectBookDetails(List<String> tagsIdList);

}
