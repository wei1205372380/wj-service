package com.linbowen.wj.controller;

import com.linbowen.wj.annotation.PassToken;
import com.linbowen.wj.result.BaseResponse;
import com.linbowen.wj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/sub/{id}")
    public BaseResponse getSubTags(@PathVariable String id) {
        return BaseResponse.buildSuccess(tagService.getSubTags(id));
    }

    @GetMapping("/sub/all/{id}")
    public BaseResponse getAllSubTags(@PathVariable String id) {
        return BaseResponse.buildSuccess(tagService.getAllSubTags(id));
    }

}
