package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonFrenzy30 extends GaugeAttackSkill {
    public DemonFrenzy30() {
        this.setName("데몬 프렌지(30)");
        this.setAttackCount(3L);
        this.setDamage(840.0);
        this.setInterval(240L);
        this.addFinalDamage(1.6);   // 코어 강화
    }
}
