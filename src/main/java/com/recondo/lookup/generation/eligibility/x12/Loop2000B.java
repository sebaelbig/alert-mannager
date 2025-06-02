package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Loop2000B  implements Serializable {
    private static final long serialVersionUID = 0L;
    private Loop2100B loop2100B;
    private List<REF> refs;
}
