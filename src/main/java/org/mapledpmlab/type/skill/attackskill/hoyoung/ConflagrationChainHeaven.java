package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ConflagrationChainHeaven extends AttackSkill {
    public ConflagrationChainHeaven() {
        this.setName("멸화염 : 천");
        this.setDamage(555.0);
        this.setDelayByAttackSpeed(540L);
        this.setAttackCount(6L);
        this.setCooldown(8.0);
        this.setRelatedSkill(new ConflagrationChainHeavenFalseTrue());
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
