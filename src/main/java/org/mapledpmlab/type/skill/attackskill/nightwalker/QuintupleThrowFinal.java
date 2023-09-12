package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class QuintupleThrowFinal extends AttackSkill implements DarkAttack {
    public QuintupleThrowFinal() {
        this.setName("퀸터플 스로우(막타)");
        this.setAttackCount(1L);
        this.setDamage(1320.0);
        this.setDotDuration(150L);
        this.setInterval(75L);
        this.setLimitAttackCount(2L);
        this.setAddDamage(20 + 20L);    // 퀸터플 스로우-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setApplyFinalAttack(true);
        this.setRelatedSkill(new QuintupleThrowFinalDelay());
    }
}
