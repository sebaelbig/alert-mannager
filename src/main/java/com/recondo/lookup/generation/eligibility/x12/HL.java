package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;

@Data
public class HL  implements Serializable {
    private static final long serialVersionUID = 0L;
    private Short HL01;
    private Short HL02;
    private Short HL03;
    private Short HL04;
}
