package com.linbowen.wj.controller;

import com.linbowen.wj.pojo.BookComment;
import com.linbowen.wj.pojo.BookScore;
import com.linbowen.wj.result.BaseResponse;
import com.linbowen.wj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public BaseResponse getAll() {
        return BaseResponse.buildSuccess(bookService.getAll());
    }

    @GetMapping("/details/{tagId}")
    public BaseResponse getBookDetails(@PathVariable String tagId) {
        return BaseResponse.buildSuccess(bookService.getBookDetails(tagId));
    }

    @GetMapping("/scores/{bookId}")
    public BaseResponse getBookScores(@PathVariable Integer bookId) {
        return BaseResponse.buildSuccess(bookService.getBookScores(bookId));
    }

    @PostMapping("/score")
    public BaseResponse updateScore(@RequestBody BookScore bookScore) {
        bookService.updateScore(bookScore);
        return  BaseResponse.buildSuccess("评分成功");
    }

    @PostMapping("/comment")
    public BaseResponse addComment(@RequestBody BookComment bookComment) {
        bookService.addComment(bookComment);
        return BaseResponse.buildSuccess("评论成功");
    }

}
