package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LawOfGravity extends AttackSkill {
    public LawOfGravity() {
        this.setName("로 오브 그라비티");
        this.setDamage(440.0);
        this.setAttackCount(6L);
        this.setDelay(960L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new LawOfGravityPull1());
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
