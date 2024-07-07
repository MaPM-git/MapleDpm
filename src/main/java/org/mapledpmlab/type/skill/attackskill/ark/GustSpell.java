package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GustSpell extends AttackSkill {
    public GustSpell() {
        this.setName("거스트 스펠");
        this.setDamage(370.0);
        this.setAttackCount(4L);
        this.getMultiAttackInfo().add(500L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
