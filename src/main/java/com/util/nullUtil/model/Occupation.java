package com.util.nullUtil.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Occupation {
    String name;
    String desc;
    Integer wage;
    Level level;

}
