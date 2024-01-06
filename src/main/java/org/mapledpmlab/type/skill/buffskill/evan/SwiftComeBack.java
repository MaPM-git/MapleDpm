package org.mapledpmlab.type.skill.buffskill.evan;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SwiftComeBack extends BuffSkill {
    public SwiftComeBack() {
        this.setName("스위프트-돌아와!");
        this.setDelay(30L);
        this.addBuffFinalDamage(1.1);
        this.setDuration(60L);
    }
}
