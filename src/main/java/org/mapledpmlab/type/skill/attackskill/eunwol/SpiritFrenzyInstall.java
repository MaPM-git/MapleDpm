package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritFrenzyInstall extends AttackSkill {
    public SpiritFrenzyInstall() {
        this.setName("소혼 장막(정령집속 자동)");
        this.setDamage(175.0);
        this.setAttackCount(5L);
        this.setDotDuration(5040L);
        this.setInterval(180L);
        this.setLimitAttackCount(28L);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
