package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DireWolfsCurse extends AttackSkill {
    public DireWolfsCurse() {
        this.setName("다이어 울프의 저주");
        this.setDamage(1045.0 + 100);
        this.setAttackCount(4L);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
