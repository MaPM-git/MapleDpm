package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivinePunishmentDelay extends AttackSkill {
    public DivinePunishmentDelay() {
        this.setName("디바인 퍼니시먼트");
        this.setDelay(240L);
        this.setCooldown(76.5);
        this.setRelatedSkill(new DivinePunishment());
    }
}
