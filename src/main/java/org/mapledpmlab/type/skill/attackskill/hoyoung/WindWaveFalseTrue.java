package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WindWaveFalseTrue extends AttackSkill {
    public WindWaveFalseTrue() {
        this.setName("파초풍 : 천 허/실");
        this.setDamage(420.0);
        //this.setDelayByAttackSpeed(540L);
        this.setAttackCount(5L);
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
