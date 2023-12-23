package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JaguarMaximum extends AttackSkill {
    public JaguarMaximum() {
        this.setName("재규어 맥시멈");
        this.setDotDuration(2160L);
        this.setLimitAttackCount(9L);
        this.setInterval(240L);
        this.setDamage(740.0);
        this.setAttackCount(12L);
        this.addCriticalP(100.0);
        this.addIgnoreDefenseList(100L);
        this.setRelatedSkill(new JaguarMaximumDelay());
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
