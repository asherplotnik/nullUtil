package com.util.nullUtil.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Level {
    String name;
    Integer category;
    public String getNameUpperCase(Boolean upper) {
        if (upper) {
            return name.toUpperCase();
        } else {
            return name;
        }
    }

}
