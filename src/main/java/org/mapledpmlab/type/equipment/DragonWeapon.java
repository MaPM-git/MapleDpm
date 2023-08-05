package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DragonWeapon extends Item {

    public DragonWeapon() {
        super();
        this.addMainStat(10L);
        this.addMainStat(10L);
        this.addMainStat(10L);
        this.addMagic(10L);
    }
}
