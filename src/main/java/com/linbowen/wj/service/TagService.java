package com.linbowen.wj.service;

import com.linbowen.wj.dto.TagAndSubTags;
import com.linbowen.wj.pojo.Tag;

import java.util.List;

public interface TagService {

    /**
     * 获取子标签
     * @param id
     * @return
     */
    List<Tag> getSubTags(String id);

    /**
     * 获取所有后代标签
     * @param id
     * @return
     */
    List<TagAndSubTags> getAllSubTags(String id);

    /**
     * 获取所有后代标签的id
     * @param id
     * @return
     */
    void getAllSubTagsId(String id, List<String> subTagsIdList);

}
