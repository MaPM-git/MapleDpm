package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Title extends Item {

    public Title() {
        super();
        this.addMainStat(20L);
        this.addSubStat(20L);
        this.addOtherStat1(20L);
        this.addOtherStat2(20L);
        this.addAtt(10L);
        this.addMagic(10L);
        this.addBossDamage(10L);
    }
}
