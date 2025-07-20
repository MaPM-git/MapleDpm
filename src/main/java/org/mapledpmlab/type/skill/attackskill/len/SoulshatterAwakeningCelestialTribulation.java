package org.mapledpmlab.type.skill.attackskill.len;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulshatterAwakeningCelestialTribulation extends AttackSkill {
    public SoulshatterAwakeningCelestialTribulation() {
        this.setName("망혼각성(천겁)");
        this.setAttackCount(12L);
        this.setDamage(1950.0);
        this.addFinalDamage(1.6);
        this.getMultiAttackInfo().add(960L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
