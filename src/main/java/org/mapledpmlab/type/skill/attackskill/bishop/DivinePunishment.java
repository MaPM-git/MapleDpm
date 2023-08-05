package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivinePunishment extends AttackSkill {
    public DivinePunishment() {
        this.setName("디바인 퍼니시먼트");
        this.setDamage(535.0);
        this.setAttackCount(10L);
        this.setCooldown(64.0);
        this.setDotDuration(10000L);
        this.setInterval(240L);
        this.setLimitAttackCount(8L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new DivinePunishmentDelay());
    }
}
