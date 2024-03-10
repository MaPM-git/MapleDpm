package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Grave extends AttackSkill {
    public Grave() {
        this.setName("그레이브");
        this.setDamage(225.0);
        this.setAttackCount(10L);
        this.setDelayByAttackSpeed(840L);
        this.setCooldown(10.0);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
