package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainArtsFury extends AttackSkill {
    public ChainArtsFury() {
        this.setName("체인아츠:퓨리");
        this.setDamage(550.0);
        this.setAttackCount(6L);
        this.setCooldown(0.6);
        this.addFinalDamage(1.6);           // 코어강화
    }
}
