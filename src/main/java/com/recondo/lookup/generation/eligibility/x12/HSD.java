package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;

@Data
public class HSD  implements Serializable {
    private static final long serialVersionUID = 0L;
    private String HSD01;
    private Double HSD02;
    private String HSD03;
    private Double HSD04;
    private String HSD05;
    private Short HSD06;
    private String HSD07;
    private String HSD08;
}
