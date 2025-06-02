package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;

@Data
public class Loop2100B implements Serializable {
    private static final long serialVersionUID = 0L;
    private NM1 nm1;
    private PRV prv;
    private REF ref;
}
