package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Blossom extends AttackSkill {
    public Blossom(Long etherSword) {
        this.setName("블로섬");
        this.setDamage(656.0);
        this.setAttackCount(8L * etherSword);
        this.setCooldown(20.0 - 5); // 블로섬-쿨타임 리듀스
        this.addFinalDamage(0.75);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
