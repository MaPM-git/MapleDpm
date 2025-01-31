package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlissfulRestraint extends AttackSkill {
    public BlissfulRestraint() {
        this.setName("황홀한 구속");
        this.setDamage(1200.0);
        this.setAttackCount(6L);
        this.setDelayByAttackSpeed(900L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
