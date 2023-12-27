package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HologramGraffitiForceFieldDelay extends AttackSkill {
    public HologramGraffitiForceFieldDelay() {
        this.setName("홀로그램 그래피티 : 역장");
        this.setDelay(930L);
        this.setRelatedSkill(new HologramGraffitiForceField());
        this.setCooldown(60.0);
    }
}
