package org.mapledpmlab.type.skill.buffskill.hero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.hero.SwordIllusionSlash;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SwordIllusionBuff extends BuffSkill {
    public SwordIllusionBuff() {
        this.setName("소드 일루전(버프)");
        this.setBuffPlusFinalDamage(1.0725);
        this.setCooldown(30.0);
        this.setDuration(8L);
        this.setRelatedSkill(new SwordIllusionSlash());
    }
}
