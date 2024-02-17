package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class QuintupleThrow extends AttackSkill implements DarkAttack {
    public QuintupleThrow() {
        this.setName("퀸터플 스로우");
        this.setAttackCount(4L);
        this.setDamage(330.0);
        this.setDelay(240L);
        this.setDotDuration(240L);
        this.setInterval(120L);
        this.setLimitAttackCount(2L);
        this.setAddDamage(20 + 20L);    // 퀸터플 스로우-리인포스, 보스 킬러
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.setRelatedSkill(new QuintupleThrowFinal());
        this.setApplyFinalAttack(true);
    }
}
