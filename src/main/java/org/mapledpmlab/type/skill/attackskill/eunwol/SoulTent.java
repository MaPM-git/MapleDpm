package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulTent extends AttackSkill {
    public SoulTent() {
        this.setName("소혼 장막");
        this.setAttackCount(8L);
        this.setDamage(557.0);
        this.setDelayByAttackSpeed(630L);
        this.setDotDuration(60000L);
        this.setInterval(3240L);
        this.setCooldown(60.0);
        this.addFinalDamage(2.8);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
