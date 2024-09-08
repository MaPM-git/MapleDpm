package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PsychicTornadoThrow extends AttackSkill {
    public PsychicTornadoThrow() {
        this.setName("싸이킥 토네이도(이동)");
        this.setDamage(433.0);
        this.setDelay(720L);
        this.setAttackCount(4L);
        this.addFinalDamage(3.0);
        this.addFinalDamage(1.6);   // 코어강화
        this.getMultiAttackInfo().add(20000L + 180L + 540);
        this.setRelatedSkill(new PsychicTornadoBomb());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
