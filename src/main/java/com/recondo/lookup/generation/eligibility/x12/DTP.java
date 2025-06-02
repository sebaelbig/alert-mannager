package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;

@Data
public class DTP  implements Serializable {
    private static final long serialVersionUID = 0L;
    private String DTP01;
    private String DTP02;
    private String DTP03;
}
