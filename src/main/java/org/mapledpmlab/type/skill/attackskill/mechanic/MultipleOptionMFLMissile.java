package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MultipleOptionMFLMissile extends AttackSkill {
    public MultipleOptionMFLMissile() {
        this.setName("멀티플 옵션 : M-FL(미사일)");
        this.setAttackCount(8L);
        this.setDamage(650.0);
        this.addFinalDamage(2.11);          // 로봇 마스터리
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
