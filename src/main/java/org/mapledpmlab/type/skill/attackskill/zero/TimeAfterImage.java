package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TimeAfterImage extends AttackSkill {
    public TimeAfterImage() {
        this.setName("시간의 축복 잔상");
        this.setAttackCount(3L);
        this.setDamage(385.0);
        this.getMultiAttackInfo().add(450L);
    }
}
