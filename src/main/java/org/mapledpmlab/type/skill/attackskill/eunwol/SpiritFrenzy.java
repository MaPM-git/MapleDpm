package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritFrenzy extends AttackSkill {
    public SpiritFrenzy() {
        this.setName("소혼 장막");
        this.setDamage(175.0);
        this.setAttackCount(5L);
        this.setDotDuration(5040L);
        this.setInterval(180L);
        this.setLimitAttackCount(28L);
        this.setCooldown(10.0);
        this.setApplyReuse(true);
        this.setRelatedSkill(new SpiritFrenzyDelay());
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
