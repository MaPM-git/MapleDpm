package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrystalIgnitionBeforeDelay extends AttackSkill {
    public CrystalIgnitionBeforeDelay() {
        this.setName("크리스탈 이그니션(선딜)");
        this.setDelay(720L);
        this.setCooldown(180.0);
        this.setRelatedSkill(new CrystalIgnition());
    }
}
