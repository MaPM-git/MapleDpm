package org.mapledpmlab.type.skill.buffskill.hero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.attackskill.hero.SwordOfBurningSoulDot;

@Getter
@Setter
public class SwordOfBurningSoulBuff extends BuffSkill {
    public SwordOfBurningSoulBuff() {
        this.setName("소드 오브 버닝 소울");
        this.setRelatedSkill(new SwordOfBurningSoulDot());
        this.setCooldown(120.0);
        this.setDelay(1620L);           // 설치 포함
        this.setDuration(75L);
    }
}
