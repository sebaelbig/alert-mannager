package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;

@Data
public class PRV  implements Serializable {
    private static final long serialVersionUID = 0L;
    private String PRV01;
    private String PRV02;
    private String PRV03;
}
