package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class EarthBreakElectricity extends DotAttackSkill {
    public EarthBreakElectricity() {
        this.setName("어스 브레이크(전기 지역)");
        this.setAttackCount(1L);
        this.setDamage(545.0);
        this.setDotDuration(5000L);
        this.setInterval(1000L);
    }
}
