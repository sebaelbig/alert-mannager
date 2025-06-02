package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Loop2000C  implements Serializable {
    private static final long serialVersionUID = 0L;
    private Loop2100C loop2100C;
    private HL hl;
    private List<DTP> dtps;
    private List<REF> refs;
}
