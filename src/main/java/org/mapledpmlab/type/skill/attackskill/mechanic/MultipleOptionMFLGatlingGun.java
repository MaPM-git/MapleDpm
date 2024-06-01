package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MultipleOptionMFLGatlingGun extends AttackSkill {
    public MultipleOptionMFLGatlingGun() {
        this.setName("멀티플 옵션 : M-FL(개틀링 건)");
        this.setAttackCount(6L);
        this.setDamage(440.0);
        this.addFinalDamage(2.11);          // 로봇 마스터리
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
