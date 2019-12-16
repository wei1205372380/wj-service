package com.linbowen.wj.service.impl;

import com.linbowen.wj.dto.TagAndSubTags;
import com.linbowen.wj.mapper.TagMapper;
import com.linbowen.wj.pojo.Tag;
import com.linbowen.wj.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> getSubTags(String id) {
        return tagMapper.selectSubTags(id);
    }

    @Override
    public List<TagAndSubTags> getAllSubTags(String id) {
        ArrayList<TagAndSubTags> tagAndSubTagsArrayList = new ArrayList<>();

        List<Tag> subTags = tagMapper.selectSubTags(id);
        if (subTags == null || subTags.isEmpty()) {
            return tagAndSubTagsArrayList;
        }
        for (Tag tag : subTags) {
            if ("000".equals(tag.getId())) {
                continue;
            }
            TagAndSubTags tagAndSubTags = new TagAndSubTags();
            tagAndSubTags.setId(tag.getId());
            tagAndSubTags.setName(tag.getName());
            tagAndSubTags.setChildren(getAllSubTags(tag.getId()));
            tagAndSubTagsArrayList.add(tagAndSubTags);
        }

        return tagAndSubTagsArrayList;
    }

    @Override
    public void getAllSubTagsId(String id, List<String> subTagsIdList) {
        List<Tag> subTags = tagMapper.selectSubTags(id);
        if (subTags == null || subTags.isEmpty()) {
            return;
        }
        for (Tag tag : subTags) {
            if ("000".equals(tag.getId())) {
                continue;
            }

            subTagsIdList.add(tag.getId());
            getAllSubTagsId(tag.getId(), subTagsIdList);
        }
    }
}
