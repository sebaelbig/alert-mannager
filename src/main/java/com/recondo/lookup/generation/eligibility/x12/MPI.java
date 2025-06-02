package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;

@Data
public class MPI  implements Serializable {
    private static final long serialVersionUID = 0L;
    private String MPI01;
    private String MPI02;
    private String MPI03;
    private String MPI04;
    private String MPI05;
    private String MPI06;
    private String MPI07;
}
