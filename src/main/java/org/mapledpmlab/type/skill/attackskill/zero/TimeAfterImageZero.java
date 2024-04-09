package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TimeAfterImageZero extends AttackSkill {
    public TimeAfterImageZero() {
        this.setName("시간의 축복 잔상(제로)");
        this.setAttackCount(3L);
        this.setDamage(440.0);
        this.getMultiAttackInfo().add(450L);
    }
}
