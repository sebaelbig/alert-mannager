package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Loop2120  implements Serializable {
    private static final long serialVersionUID = 0L;
    private NM1 nm1;
    private N3 n3;
    private N4 n4;
    private PRV prv;
    private List<PER> pers;
}
