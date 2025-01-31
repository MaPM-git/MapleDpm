package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BeholderPunishment extends AttackSkill {
    public BeholderPunishment() {
        this.setName("비홀더스 퍼니시먼트");
        this.setDamage(223.0 + 55);
        this.setAttackCount(5L);
        this.setAddDamage(150L);        // 비홀더-리인포스
        this.addFinalDamage(2.8);
        this.addIgnoreDefenseList(20L);
    }
}
