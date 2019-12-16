package com.linbowen.wj.dto;

import java.util.List;

public class TagAndSubTags {

    private String id;

    private String name;

    private List<TagAndSubTags> children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TagAndSubTags> getChildren() {
        return children;
    }

    public void setChildren(List<TagAndSubTags> children) {
        this.children = children;
    }
}
