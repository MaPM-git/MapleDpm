package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GripOfAgony extends AttackSkill {
    public GripOfAgony() {
        this.setName("그립 오브 애거니");
        this.setDamage(1100.0);
        this.setAttackCount(8L);
        this.setDelay(660L);
        this.setDotDuration(9000L);
        this.setInterval(330L);
        this.setLimitAttackCount(27L);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
