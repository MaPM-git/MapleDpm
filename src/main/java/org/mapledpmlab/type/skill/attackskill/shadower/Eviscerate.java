package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Eviscerate extends AttackSkill {
    public Eviscerate() {
        this.setName("절개");
        this.setAttackCount(7L * 2);
        this.setDamage(1815.0);
        this.setCooldown(20.0);
        this.setDelay(570L);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(0.85);      // 쉐도우 파트너
        this.getMultiAttackInfo().add(150L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
