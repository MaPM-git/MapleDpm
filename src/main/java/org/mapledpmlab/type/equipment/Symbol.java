package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Symbol extends Item {

    public Symbol() {
        super();
        this.addPerXMainStat(13200L);
        this.addPerXMainStat((long) (2500 * 6));
    }
}
