package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LawOfGravityPull3 extends AttackSkill {
    public LawOfGravityPull3() {
        this.setName("로 오브 그라비티(끌어당기기3)");
        this.setDamage(1100.0);
        this.setAttackCount(8L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(1.24);
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(1980L + 2790 - 210);
        this.setRelatedSkill(new LawOfGravityPull4());
    }
}
