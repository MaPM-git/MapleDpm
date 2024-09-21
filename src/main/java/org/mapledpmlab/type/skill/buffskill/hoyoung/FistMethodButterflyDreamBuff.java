package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.hoyoung.FistMethodButterflyDreamAttack;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FistMethodButterflyDreamBuff extends BuffSkill {
    public FistMethodButterflyDreamBuff() {
        this.setName("권술 : 호접지몽");
        this.setDuration(100L);
        this.addBuffFinalDamage(1.1);
        this.setDelay(600L);
        this.setApplyServerLag(true);
    }
}
