package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ConflagrationChainHeavenFalseTrue extends AttackSkill {
    public ConflagrationChainHeavenFalseTrue() {
        this.setName("멸화염 : 허/실");
        this.setDamage(555.0);
        this.setDelayByAttackSpeed(690L);
        this.setAttackCount(6L);
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
