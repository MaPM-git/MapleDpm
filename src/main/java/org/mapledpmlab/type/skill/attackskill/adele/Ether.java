package org.mapledpmlab.type.skill.attackskill.adele;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Ether extends AttackSkill {
    public Ether() {
        this.setName("에테르(자동 충전)");
        this.setCooldown(10.0);
        this.setApplyCooldownReduction(false);
    }
}
