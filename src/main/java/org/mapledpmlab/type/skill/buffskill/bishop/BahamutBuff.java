package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BahamutBuff extends BuffSkill {
    public BahamutBuff() {
        this.setName("바하뮤트(버프)");
        this.setBuffFinalDamage(1.26);
    }
}
