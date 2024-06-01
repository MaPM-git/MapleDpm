package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonFrenzy29 extends GaugeAttackSkill {
    public DemonFrenzy29() {
        this.setName("데몬 프렌지(29)");
        this.setAttackCount(3L);
        this.setDamage(825.0);
        this.setInterval(240L);
        this.addFinalDamage(1.6);   // 코어 강화
    }
}
