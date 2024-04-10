package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UltimatePsychicBulletBlackHole extends AttackSkill {
    public UltimatePsychicBulletBlackHole() {
        this.setName("얼티메이트-싸이킥 불릿(블랙홀)");
        this.setDamage(1100.0);
        this.setAttackCount(3L);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(1410L);
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(270L);
    }
}
