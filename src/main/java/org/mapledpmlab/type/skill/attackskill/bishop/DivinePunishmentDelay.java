package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivinePunishmentDelay extends AttackSkill {
    public DivinePunishmentDelay() {
        this.setName("디바인 퍼니시먼트(선딜)");
        this.setDelay(240L);
        this.setCooldown(55.0);
        this.setRelatedSkill(new DivinePunishment());
        this.setApplyCooldownReduction(false);
    }
}
