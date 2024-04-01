package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PlainSpell extends AttackSkill {
    public PlainSpell() {
        this.setName("플레인 스펠");
        this.setDamage(595.0 + 160 + 163);
        this.setAttackCount(1L);
        this.getMultiAttackInfo().add(500L);
        this.getMultiAttackInfo().add(100L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20 + 5);    // 배틀 아츠-리인포스
    }
}
