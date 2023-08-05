package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Medal extends Item {

    public Medal() {
        super();
        this.addMainStat(7L);
        this.addSubStat(7L);
        this.addOtherStat1(7L);
        this.addOtherStat2(7L);
        this.addAtt(7L);
        this.addMagic(7L);
        this.addIgnoreDefenseList(10L);
    }
}
