package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlissfulRestraintDot extends AttackSkill {
    public BlissfulRestraintDot() {
        this.setName("황홀한 구속(도트)");
        this.setDamage(410.0);
        this.setAttackCount(3L);
        this.setCooldown(120.0);
        this.setDotDuration(9000L);
        this.setInterval(450L);
        this.setLimitAttackCount(20L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new BlissfulRestraintFinish());
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
