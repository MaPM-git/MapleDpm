package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritFrenzyInstall extends AttackSkill {
    public SpiritFrenzyInstall() {
        this.setName("소혼 장막(정령집속 자동)");
        this.setDamage(270.0);
        this.setAttackCount(5L);
        this.setDotDuration(2700L);
        this.setInterval(90L);
        this.setLimitAttackCount(30L);
        this.addFinalDamage(2.8);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
