package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EB  implements Serializable {
    private static final long serialVersionUID = 0L;
    private String type;
    private String EB01;
    private String EB02;
    private String EB03;
    private String EB04;
    private String EB05;
    private String EB06;
    private Double EB07;
    private Double EB08;
    private String EB09;
    private Double EB10;
    private String EB11;
    private String EB12;
    private EB13 EB13;
    private List<HSD> hsds;
    private List<REF> refs;
    private List<DTP> dtps;
    private List<String> msgs;
    private NM1 nm1;
    private N3 n3;
    private N4 n4;
    private List<PER> pers;
    private PRV prv;
    private List<Loop2120> loop2120s;

}
