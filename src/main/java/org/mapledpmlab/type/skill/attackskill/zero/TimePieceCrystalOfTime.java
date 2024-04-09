package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TimePieceCrystalOfTime extends AttackSkill {
    public TimePieceCrystalOfTime() {
        this.setName("시간의 결정");
        this.setAttackCount(4L);
        this.setDamage(1440.0);
        this.getMultiAttackInfo().add(720L);
    }
}
