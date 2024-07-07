package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ScarletSpell extends AttackSkill {
    public ScarletSpell() {
        this.setName("스칼렛 스펠");
        this.setDamage(355.0);
        this.setAttackCount(5L);
        this.getMultiAttackInfo().add(500L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
