package org.mapledpmlab.type.skill.buffskill.shadower;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class VeilOfShadowBuff extends BuffSkill {
    public VeilOfShadowBuff() {
        this.setName("베일 오브 섀도우");
        this.setDelayByAttackSpeed(900L);
        this.setDuration(12L);
        this.addBuffFinalDamage(1.15);      // 어드밴스드 다크 사이트
        this.setRelatedSkill(new DarkSight());
    }
}
