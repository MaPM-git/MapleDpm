package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MultipleOptionMFLMissile extends AttackSkill {
    public MultipleOptionMFLMissile() {
        this.setName("멀티플 옵션 : M-FL(미사일)");
        this.setDotDuration(135000L);
        this.setInterval(1500L);
        this.setAttackCount(6L);
        this.setDamage(440.0);
        this.setRelatedSkill(new MultipleOptionMFLGatlingGun());
        this.addFinalDamage(2.11);          // 로봇 마스터리
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
