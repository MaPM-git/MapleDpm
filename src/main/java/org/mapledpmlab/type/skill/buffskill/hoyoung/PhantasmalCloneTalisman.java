package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PhantasmalCloneTalisman extends BuffSkill {
    public PhantasmalCloneTalisman() {
        this.setName("환영 분신부");
        this.setDelay(900L);
        this.setDuration(200L);
    }
}
