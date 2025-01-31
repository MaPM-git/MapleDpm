package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlissfulRestraintDot extends AttackSkill {
    public BlissfulRestraintDot() {
        this.setName("황홀한 구속(도트)");
        this.setDamage(900.0);
        this.setAttackCount(3L);
        this.setCooldown(120.0);
        this.setDotDuration(8100L);
        this.setInterval(390L);
        this.setLimitAttackCount(20L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new BlissfulRestraintFinish());
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
