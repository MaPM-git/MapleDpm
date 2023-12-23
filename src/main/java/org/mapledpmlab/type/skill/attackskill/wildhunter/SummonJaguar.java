package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SummonJaguar extends AttackSkill {
    public SummonJaguar() {
        this.setName("서먼 재규어");
        this.setDamage(170.0 + 30 + 40 + 50 + 150);
        this.setDotDuration(720L * 1000);
        this.setInterval(960L);
        this.setAttackCount(1L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setCooldown(0.96);
    }
}
