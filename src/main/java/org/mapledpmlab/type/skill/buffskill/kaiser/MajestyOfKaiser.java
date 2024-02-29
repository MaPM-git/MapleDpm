package org.mapledpmlab.type.skill.buffskill.kaiser;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MajestyOfKaiser extends BuffSkill {
    public MajestyOfKaiser() {
        this.setName("마제스티 오브 카이저");
        this.setDuration(30L);
        this.addBuffAttMagic(30L);
        this.setDelay(900L);
    }
}
