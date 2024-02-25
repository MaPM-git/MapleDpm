package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritFrenzy extends AttackSkill {
    public SpiritFrenzy() {
        this.setName("소혼 장막");
        this.setDamage(270.0);
        this.setAttackCount(5L);
        this.setDelay(2700L + 480);
        this.setDotDuration(2700L);
        this.setInterval(90L);
        this.setLimitAttackCount(30L);
        this.setCooldown(10.0);
        this.setApplyReuse(true);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
