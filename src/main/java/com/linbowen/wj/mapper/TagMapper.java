package com.linbowen.wj.mapper;

import com.linbowen.wj.pojo.Tag;

import java.util.List;

public interface TagMapper {

    /**
     * 第一次手动存入大量标签
     * @param list
     */
    void insertList(List<Tag> list);

    /**
     * 获取子标签
     * @param id
     * @return
     */
    List<Tag> selectSubTags(String id);

}
