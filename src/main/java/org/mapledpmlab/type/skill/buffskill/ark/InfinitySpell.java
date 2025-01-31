package org.mapledpmlab.type.skill.buffskill.ark;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class InfinitySpell extends BuffSkill {
    public InfinitySpell() {
        this.setName("인피니티 스펠");
        this.setDelayByAttackSpeed(720L);
        this.setCooldown(120.0);
        this.setDuration(50L);
        this.setApplyServerLag(true);
    }
}
