package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class StormBreakElectricity extends DotAttackSkill {
    public StormBreakElectricity() {
        this.setName("스톰 브레이크(전기 지역)");
        this.setAttackCount(1L);
        this.setDamage(370.0);
        this.setDotDuration(4000L);
        this.setInterval(1000L);
    }
}

