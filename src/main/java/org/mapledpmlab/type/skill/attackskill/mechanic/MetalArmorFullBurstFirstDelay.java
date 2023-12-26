package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MetalArmorFullBurstFirstDelay extends AttackSkill {
    public MetalArmorFullBurstFirstDelay() {
        this.setName("메탈아머 전탄발사");
        this.setDelay(960L);
        this.setRelatedSkill(new MetalArmorFullBurst());
        this.setCooldown(180.0);
    }
}
