package org.mapledpmlab.type.skill.buffskill.eunwol;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.eunwol.DivisionSoul;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class DivisionSoulBuff extends BuffSkill {
    public DivisionSoulBuff() {
        this.setName("분혼 격참-화염 정령의 가호");
        this.setCooldown(60.0);
        this.setDuration(30L);
        this.addBuffFinalDamage(1.2);
        this.setRelatedSkill(new DivisionSoul());
        this.setApplyServerLag(true);
    }
}
