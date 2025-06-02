package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Loop2100C  implements Serializable {
    private static final long serialVersionUID = 0L;
    private Loop2110C loop2110C;
    private NM1 nm1;
    private N3 n3;
    private N4 n4;
    private DMG dmg;
    private INS ins;
    private MPI mpi;
    private HI hi;
    private PRV prv;
    private List<PER> pers;
}
