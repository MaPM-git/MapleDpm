package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnstoppableImpulse extends AttackSkill implements LefSkill {
    public UnstoppableImpulse() {
        this.setName("멈출 수 없는 충동");
        this.setDamage(110.0 + 150 + 178 + 250);
        this.setAttackCount(5L);
        this.setCooldown(6.0);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
