package org.mapledpmlab.type.skill.buffskill.kain;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AnnihilationBuff extends BuffSkill {
    public AnnihilationBuff() {
        this.setName("악의의 영지");
        this.setDuration(30L);
    }
}
