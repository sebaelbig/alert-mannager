package com.recondo.lookup.generation.eligibility;

import com.recondo.lookup.generation.eligibility.x12.*;
import com.recondo.lookup.generation.eligibility.x12.TRN;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class X12Response implements Serializable {
    private static final long serialVersionUID = 0L;
    private ISA isa;
    private ST st;
    private BHT bht;
    private GS gs;
    private List<TRN> trns;
    private List<REF> refs;

    private Loop2000A loop2000A;
    private Loop2000B loop2000B;
    private Loop2000C loop2000C;
    private Loop2000D loop2000D;
}
