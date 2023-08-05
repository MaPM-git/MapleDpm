package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Emblem extends Item {

    public Emblem() {
        super();
        this.addMainStat(40L);
        this.addSubStat(40L);
        this.addAtt(5L);
        this.addMagic(5L);
        this.addHp(700L / 2);
        this.addAttP(30L);
        this.addAttP(21L);
    }
}
