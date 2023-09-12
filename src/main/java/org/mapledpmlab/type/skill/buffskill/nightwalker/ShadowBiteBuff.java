package org.mapledpmlab.type.skill.buffskill.nightwalker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.nightwalker.ShadowBite;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ShadowBiteBuff extends BuffSkill {
    public ShadowBiteBuff() {
        this.setName("쉐도우 바이트");
        this.setCooldown(10.0);         // 코어강화
        this.addBuffFinalDamage(1.2);
        this.setDuration(20L);
        this.setRelatedSkill(new ShadowBite());
    }
}
