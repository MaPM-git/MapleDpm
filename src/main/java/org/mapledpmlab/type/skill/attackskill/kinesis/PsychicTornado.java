package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PsychicTornado extends AttackSkill {
    public PsychicTornado() {
        this.setName("싸이킥 토네이도");
        this.setDamage(1650.0);
        this.setDelay(720L);
        this.setAttackCount(8L);
        this.setCooldown(180.0);
        this.setApplyFinalAttack(true);
        this.setDotDuration(20000L);
        this.setInterval(1000L);
        this.setLimitAttackCount(20L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new PsychicTornadoThrow());
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
