package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlossomRestore extends AttackSkill {
    public BlossomRestore() {
        this.setName("블로섬(리스토어)");
        this.setDamage(656.0);
        this.setAttackCount(8L * 8);
        this.setCooldown(20.0 - 5); // 블로섬-쿨타임 리듀스
        this.addFinalDamage(6.25 / 8);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
