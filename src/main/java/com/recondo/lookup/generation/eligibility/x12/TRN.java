package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;

@Data
public class TRN  implements Serializable {
    private static final long serialVersionUID = 0L;
    private String TRN01;
    private String TRN02;
    private String TRN03;
    private String TRN04;
}
