package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritFrenzy6th extends AttackSkill {
    public SpiritFrenzy6th() {
        this.setName("소혼 장막(6차)");
        this.setDamage(270.0);
        this.setAttackCount(5L);
        this.setDotDuration(2700L);
        this.setInterval(90L);
        this.setLimitAttackCount(30L);
        this.setCooldown(13.0);
        this.setApplyReuse(true);
        this.addFinalDamage(6.5);
        this.addFinalDamage(2.8);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
