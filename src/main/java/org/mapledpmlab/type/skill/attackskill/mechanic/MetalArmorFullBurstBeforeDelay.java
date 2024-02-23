package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MetalArmorFullBurstBeforeDelay extends AttackSkill {
    public MetalArmorFullBurstBeforeDelay() {
        this.setName("메탈아머 전탄발사");
        this.setDelay(1020L);
        this.setRelatedSkill(new MetalArmorFullBurst());
        this.setCooldown(180.0);
    }
}
