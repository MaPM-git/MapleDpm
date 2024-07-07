package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LawOfGravityPull1 extends AttackSkill {
    public LawOfGravityPull1() {
        this.setName("로 오브 그라비티(끌어당기기1)");
        this.setDamage(1100.0);
        this.setAttackCount(8L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new LawOfGravityPull2());
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
