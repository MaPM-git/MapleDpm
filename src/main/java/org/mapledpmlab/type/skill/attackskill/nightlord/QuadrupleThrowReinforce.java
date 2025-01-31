package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class QuadrupleThrowReinforce extends AttackSkill {
    public QuadrupleThrowReinforce() {
        this.setName("강화 쿼드러플 스로우");
        this.setApplyFinalAttack(true);
        this.setAttackCount((4L + 1) * 2);  // 쿼드러플 스로우-보너스 어택
        this.setDamage(990.0 + 60);
        this.setDelayByAttackSpeed(780L);
        this.setAddDamage(20 + 20L);    // 쿼드러플 스로우-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
    }
}
