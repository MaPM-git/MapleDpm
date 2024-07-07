package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PsychicTornadoBomb extends AttackSkill {
    public PsychicTornadoBomb() {
        this.setName("싸이킥 토네이도(폭발)");
        this.setDamage(975.0);
        this.setAttackCount(10L);
        this.addFinalDamage(3.0);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(20000L + 1560L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
