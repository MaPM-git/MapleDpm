package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IncisingDot extends AttackSkill {
    public IncisingDot() {
        this.setName("인사이징(도트)");
        this.setAttackCount(1L);
        this.setDamage(168.0);      // 쓸컴뱃 기준
        this.setFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setInterval(2000L);
    }
}
