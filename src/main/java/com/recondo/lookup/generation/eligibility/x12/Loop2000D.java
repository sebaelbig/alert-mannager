package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Loop2000D  implements Serializable {
    private static final long serialVersionUID = 0L;
    private Loop2100D loop2100D;
    private HL hl;
    private List<DTP> dtps;
    private List<REF> refs;
}
