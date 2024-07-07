package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LawOfGravityPull2 extends AttackSkill {
    public LawOfGravityPull2() {
        this.setName("로 오브 그라비티(끌어당기기2)");
        this.setDamage(1100.0);
        this.setAttackCount(8L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(1.12);
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(2790L - 210);
        this.setRelatedSkill(new LawOfGravityPull3());
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
