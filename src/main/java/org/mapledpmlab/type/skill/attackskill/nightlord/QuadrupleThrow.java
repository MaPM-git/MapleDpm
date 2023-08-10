package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class QuadrupleThrow extends AttackSkill {
    public QuadrupleThrow() {
        this.setName("쿼드러플 스로우");
        this.setApplyFinalAttack(true);
        this.setAttackCount(4 + 1L);    // 쿼드러플 스로우-보너스 어택
        this.setDamage(750.0);
        this.setDelayByAttackSpeed(780L);
        this.setAddDamage(20 + 20L);    // 쿼드러플 스로우-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
