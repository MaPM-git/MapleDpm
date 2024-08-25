package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TimePieceCrystalOfTime extends AttackSkill {
    public TimePieceCrystalOfTime() {
        this.setName("시간의 결정");
        this.setAttackCount(4L);
        this.setDamage(1440.0);
        this.getMultiAttackInfo().add(720L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }

    public void setMultiAttackByCnt(int cnt) {
        boolean isFirst = true;
        this.getMultiAttackInfo().clear();
        while (cnt >= 4) {
            for (int i = 0; i < 4; i++) {
                if (isFirst) {
                    this.getMultiAttackInfo().add(720L);
                    isFirst = false;
                } else {
                    this.getMultiAttackInfo().add(0L);
                }
            }
            cnt -= 4;
        }
    }
}
