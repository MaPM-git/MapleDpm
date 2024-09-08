package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Marker4 extends AttackSkill {
    public Marker4() {
        this.setName("마커(4)");
        this.setDamage(2500.0);
        this.setAttackCount(6L * 8);
        this.setCooldown(60.0);
        this.setDelayByAttackSpeed(900L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
