package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Loop2100A  implements Serializable {
    private static final long serialVersionUID = 0L;
    private NM1 nm1;
    private List<PER> pers;
}
