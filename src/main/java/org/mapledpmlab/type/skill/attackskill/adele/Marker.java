package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Marker extends AttackSkill {
    public Marker() {
        this.setName("마커");
        this.setDamage(2000.0);
        this.setAttackCount(6L * 7);
        this.setCooldown(60.0);
        this.setDelayByAttackSpeed(900L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
