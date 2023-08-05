package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Heart extends Item {

    public Heart() {
        super();
        this.addMainStat(50L);
        this.addSubStat(50L);
        this.addOtherStat1(50L);
        this.addOtherStat2(50L);
        this.addAtt(77L);
        this.addMagic(10L);
        this.addHp(100L / 2);
        this.addBossDamage(30L);
        this.addIgnoreDefenseList(30L);
    }
}
