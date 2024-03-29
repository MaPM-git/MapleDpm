package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VoidBlitz extends AttackSkill implements VoidSkill {
    public VoidBlitz() {
        this.setName("보이드 블리츠");
        this.setDamage(335.0);
        this.setAttackCount(5L * 4);
        this.setCooldown(6.0);
        //this.setDelayByAttackSpeed(510L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);     // 보이드-리인포스
    }
}
