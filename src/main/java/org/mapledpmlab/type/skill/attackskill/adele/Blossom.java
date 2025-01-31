package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Blossom extends AttackSkill {
    public Blossom() {
        this.setName("블로섬");
        this.setDamage(1100.0);
        this.setAttackCount(8L * 6);
        this.setCooldown(20.0 - 5); // 블로섬-쿨타임 리듀스
        this.addFinalDamage(4.75 / 6);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
