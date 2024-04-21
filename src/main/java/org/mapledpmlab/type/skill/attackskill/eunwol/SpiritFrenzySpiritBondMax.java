package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritFrenzySpiritBondMax extends AttackSkill {
    public SpiritFrenzySpiritBondMax() {
        this.setName("소혼 장막(정령 결속 극대화)");
        this.setDamage(150.0);
        this.setAttackCount(1L);
        this.setDotDuration(4800L);
        this.setInterval(90L);
        this.setLimitAttackCount(28L);
        this.setCooldown(60.0);
        this.addFinalDamage(2.8);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
