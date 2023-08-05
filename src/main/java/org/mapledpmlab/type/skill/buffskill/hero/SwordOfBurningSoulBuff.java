package org.mapledpmlab.type.skill.buffskill.hero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.attackskill.hero.SwordOfBurningSoulDot;

@Getter
@Setter
public class SwordOfBurningSoulBuff extends BuffSkill {
    public SwordOfBurningSoulBuff() {
        this.setRelatedSkill(new SwordOfBurningSoulDot());
        this.setCooldown(120.0);
        this.setDelay(1620L);           // 설치 포함
        this.setDuration(75L);
    }
}
