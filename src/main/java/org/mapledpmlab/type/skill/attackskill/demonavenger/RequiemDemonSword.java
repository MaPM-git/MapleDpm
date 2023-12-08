package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class RequiemDemonSword extends GaugeAttackSkill {
    public RequiemDemonSword() {
        this.setName("레퀴엠(진혼의 마검)");
        this.setDotDuration(15000L);
        this.setInterval(2100L);
        this.setAttackCount(12L);
        this.setDamage(3600.0);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(50L);
    }
}
