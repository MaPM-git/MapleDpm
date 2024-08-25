package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Marker1 extends AttackSkill {
    public Marker1() {
        this.setName("마커");
        //this.setName("마커(1)");
        this.setDamage(2000.0);
        this.setAttackCount(6L);
        //this.setAttackCount(6L * 2);
        this.setCooldown(60.0);
        this.setDelayByAttackSpeed(900L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
