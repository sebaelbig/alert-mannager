package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;

@Data
public class REF implements Serializable {
    private static final long serialVersionUID = 0L;
    private String REF01;
    private String REF02;
    private String REF03;
}
