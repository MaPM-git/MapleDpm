package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LawOfGravityPull5 extends AttackSkill {
    public LawOfGravityPull5() {
        this.setName("로 오브 그라비티(끌어당기기5)");
        this.setDamage(1100.0);
        this.setAttackCount(8L);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(1.4);
        this.setApplyFinalAttack(true);
        this.setDotDuration(22000L);
        this.setInterval(1200L);
        this.setLimitAttackCount(12L);
        this.setRelatedSkill(new LawOfGravityFinish());
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
