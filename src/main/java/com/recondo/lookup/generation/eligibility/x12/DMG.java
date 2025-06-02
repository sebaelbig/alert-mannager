package com.recondo.lookup.generation.eligibility.x12;

import lombok.Data;

import java.io.Serializable;

@Data
public class DMG  implements Serializable {
    private static final long serialVersionUID = 0L;
    private String DMG01;
    private String DMG02;
    private String DMG03;
}
