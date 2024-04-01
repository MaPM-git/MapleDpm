package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AbyssSpell extends AttackSkill {
    public AbyssSpell() {
        this.setName("어비스 스펠");
        this.setDamage(115.0);
        this.setAttackCount(2L);
        this.setDotDuration(3000L);
        this.setInterval(300L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L + 20);    // 배틀 아츠-리인포스
    }
}
