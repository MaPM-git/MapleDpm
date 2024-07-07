package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LawOfGravityFinish extends AttackSkill {
    public LawOfGravityFinish() {
        this.setName("로 오브 그라비티(폭발)");
        this.setDamage(1320.0);
        this.setAttackCount(15L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(1.4);
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(22000L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
