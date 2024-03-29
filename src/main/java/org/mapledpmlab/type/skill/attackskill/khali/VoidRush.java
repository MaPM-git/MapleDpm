package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VoidRush extends AttackSkill implements VoidSkill {
    public VoidRush() {
        this.setName("보이드 러쉬");
        this.setDamage(370.0);
        this.setAttackCount(4L);
        this.setCooldown(5.0);
        this.setDelay(210L);
        //this.setDelayByAttackSpeed(420L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);     // 보이드-리인포스
    }
}
