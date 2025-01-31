package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainArtsCrush extends AttackSkill {
    public ChainArtsCrush() {
        this.setName("체인아츠:크러시");
        this.setDamage(967.0);
        this.setAttackCount(15L);
        this.setDelayByAttackSpeed(990L);
        this.setCooldown(30.0);
        this.addFinalDamage(1.3);           // 연계
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
