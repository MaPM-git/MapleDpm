package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SneakySnipingEnchantBeforeDelay extends AttackSkill {
    public SneakySnipingEnchantBeforeDelay() {
        this.setName("[발현/처형] 스니키 스나이핑(선딜)");
        this.setDelayByAttackSpeed(420L);
        this.setCooldown(60.0);
        this.setRelatedSkill(new SneakySnipingEnchant());
        this.setApplyCooldownReduction(false);
    }
}
