package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

import java.sql.Timestamp;

public class OvermaximizingExceed extends GaugeAttackSkill {
    public OvermaximizingExceed() {
        this.setName("오버맥시마이징 익시드");
        this.setAttackCount(7L);
        this.setDamage(2400.0);
        this.setCooldown(6.0);
    }
}
