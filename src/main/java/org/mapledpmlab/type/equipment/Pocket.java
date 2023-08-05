package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pocket extends Item {

    public Pocket() {
        super(160L);
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addOtherStat1(10L);
        this.addOtherStat2(10L);
        this.addAtt(10L);
        this.addMagic(10L);
        this.addHp(100L / 2);
    }
}
