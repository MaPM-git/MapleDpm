package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MechanicWeapon extends Item {

    public MechanicWeapon() {
        super();
        this.addMainStat(15L);
        this.addSubStat(15L);
        this.addAtt(15L);
    }
}
