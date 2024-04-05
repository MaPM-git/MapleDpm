package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ConflagrationChainHeavenFlame extends AttackSkill {
    public ConflagrationChainHeavenFlame() {
        this.setName("멸화염 : 천(불꽃)");
        this.setDamage(685.0);
        this.setAttackCount(5L);
        this.setAddDamage(10L + 15);    // 천지인-리인포스
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
