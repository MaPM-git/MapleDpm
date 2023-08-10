package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class QuadrupleThrowReinforceSpread extends AttackSkill {
    public QuadrupleThrowReinforceSpread() {
        this.setName("강화 쿼드러플 스로우(스프레드 스로우)");
        this.setApplyFinalAttack(true);
        this.setAttackCount(4 + 1L);    // 쿼드러플 스로우-보너스 어택
        this.setDamage(379.0);
        this.setAddDamage(20 + 20L);    // 쿼드러플 스로우-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);
    }
}
