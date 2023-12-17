package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;
import org.mapledpmlab.type.skill.buffskill.demonavenger.ArmorBreakDebuff;

public class ArmorBreak extends GaugeAttackSkill {
    public ArmorBreak() {
        this.setName("아머 브레이크");
        this.setAttackCount(4L);
        this.setDamage(355.0);
        this.setDelayByAttackSpeed(870L);
        this.setGaugeCharge(-1000.0);
        this.setCooldown(60.0);
        this.setRelatedSkill(new ArmorBreakDebuff());
        this.setApplyFinalAttack(true);
    }
}
