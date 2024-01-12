package org.mapledpmlab.type.skill.buffskill.eunwol;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulSplitterBuff extends BuffSkill {
    public SoulSplitterBuff() {
        this.setName("분혼 격참");
        this.setDuration(10L);
        this.addBuffFinalDamage(1.2);
    }
}
