package com.linbowen.wj.service.impl;

import com.linbowen.wj.dto.BookDetails;
import com.linbowen.wj.mapper.BookCommentMapper;
import com.linbowen.wj.mapper.BookMapper;
import com.linbowen.wj.mapper.BookScoreMapper;
import com.linbowen.wj.mapper.TagMapper;
import com.linbowen.wj.pojo.Book;
import com.linbowen.wj.pojo.BookComment;
import com.linbowen.wj.pojo.BookScore;
import com.linbowen.wj.service.BookService;
import com.linbowen.wj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookScoreMapper bookScoreMapper;

    @Autowired
    private BookCommentMapper bookCommentMapper;

    @Autowired
    private TagService tagService;

    @Override
    public List<Book> getAll() {
        return bookMapper.selectAll();
    }

    @Override
    public List<BookDetails> getBookDetails(String tagId) {
        List<String> tagsIdList = new ArrayList<>();
        tagsIdList.add(tagId);
        tagService.getAllSubTagsId(tagId, tagsIdList);
        return bookMapper.selectBookDetails(tagsIdList);
    }

    @Override
    public List<BookScore> getBookScores(Integer bookId) {
        return bookScoreMapper.selectByBookId(bookId);
    }

    @Override
    public void updateScore(BookScore bookScore) {
        bookScoreMapper.insertOrUpdateScore(bookScore);
    }

    @Override
    public void addComment(BookComment bookComment) {
        bookCommentMapper.insertComment(bookComment);
    }
}
