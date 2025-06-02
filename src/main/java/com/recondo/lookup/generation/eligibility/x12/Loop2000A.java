package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Loop2000A  implements Serializable {
    private static final long serialVersionUID = 0L;
    private List<REF> refs;
    private Loop2100A loop2100A;
}
