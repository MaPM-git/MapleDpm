package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordi extends Item {

    public Coordi() {
        super();
        this.addMainStat(5L);
        this.addSubStat(5L);
        this.addOtherStat1(5L);
        this.addOtherStat2(5L);
        this.addHp(250L / 2);
        this.addAtt(3L);
        this.addMagic(3L);

        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addOtherStat1(10L);
        this.addOtherStat2(10L);
        this.addHp(500L / 2);
        this.addAtt(7L);
        this.addMagic(7L);

        this.addAtt(30L);
        this.addMagic(30L);

        this.addMainStat(30L);
        this.addSubStat(30L);
        this.addOtherStat1(30L);
        this.addOtherStat2(30L);

        this.addMainStat(30L);
        this.addSubStat(30L);
        this.addOtherStat1(30L);
        this.addOtherStat2(30L);
    }
}
