package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class QuadrupleThrowSpread extends AttackSkill {
    public QuadrupleThrowSpread() {
        this.setName("쿼드러플 스로우(스프레드 스로우)");
        this.setApplyFinalAttack(true);
        this.setAttackCount(4 + 1L);    // 쿼드러플 스로우-보너스 어택
        this.setDamage(379.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);
    }
}
