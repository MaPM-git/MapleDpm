package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LawOfGravityPull4 extends AttackSkill {
    public LawOfGravityPull4() {
        this.setName("로 오브 그라비티(끌어당기기4)");
        this.setDamage(1100.0);
        this.setAttackCount(8L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(1.36);
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(1200L + 1980 + 2790 - 210);
        this.setRelatedSkill(new LawOfGravityPull5());
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
