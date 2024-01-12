package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritFrenzy6th extends AttackSkill {
    public SpiritFrenzy6th() {
        this.setName("소혼 장막(6차)");
        this.setDamage(175.0);
        this.setAttackCount(5L);
        this.setDotDuration(5040L);
        this.setInterval(180L);
        this.setLimitAttackCount(28L);
        this.setCooldown(13.0);
        this.setApplyReuse(true);
        this.addFinalDamage(6.5);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
