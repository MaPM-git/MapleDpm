package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DoorOfTruth extends AttackSkill {
    public DoorOfTruth() {
        this.setName("진리의 문");
        this.setDamage(990.0);
        this.setAttackCount(10L);
        this.setDelay(870L);
        this.setDotDuration(40000L);
        this.setInterval(3000L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
