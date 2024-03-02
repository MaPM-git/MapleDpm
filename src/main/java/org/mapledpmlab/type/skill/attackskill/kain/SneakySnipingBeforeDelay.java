package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SneakySnipingBeforeDelay extends AttackSkill {
    public SneakySnipingBeforeDelay() {
        this.setName("스니키 스나이핑(선딜)");
        this.setDelayByAttackSpeed(420L);
        this.setCooldown(40.0);
        this.setRelatedSkill(new SneakySniping());
        this.setApplyCooldownReduction(false);
    }
}
