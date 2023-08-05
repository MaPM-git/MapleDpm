package org.mapledpmlab.type.equipment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pet extends Item {

    public Pet() {
        super();
        this.addAtt(30L);
        this.addMagic(30L);
        this.addAtt((long) (42 * 3));
        this.addMagic((long) (42 * 3));
    }
}
