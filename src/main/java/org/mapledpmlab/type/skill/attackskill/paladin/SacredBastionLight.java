package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SacredBastionLight extends AttackSkill {
    public SacredBastionLight() {
        this.setName("세이크리드 바스티온(신성한 빛)");
        this.setAttackCount(13L);
        this.setDamage(1200.0);
        this.setCooldown(0.5);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.getMultiAttackInfo().add(300L);
    }
}
