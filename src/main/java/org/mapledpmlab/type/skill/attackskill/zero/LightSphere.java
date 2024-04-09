package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightSphere extends AttackSkill {
    public LightSphere() {
        this.setName("빛의 창");
        this.setAttackCount(4L);
        this.setDamage(550.0);
        this.setCooldown(2.0);
        this.setRelatedSkill(new LightSphereDot());
        this.getMultiAttackInfo().add(540L);
    }
}
