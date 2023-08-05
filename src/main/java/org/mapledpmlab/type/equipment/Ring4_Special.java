package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ring4_Special extends Item {

    public Ring4_Special() {
        super();
        this.addMainStat(4L);
        this.addSubStat(4L);
        this.addOtherStat1(4L);
        this.addOtherStat2(4L);
        this.addAtt(4L);
        this.addMagic(4L);
    }
}
