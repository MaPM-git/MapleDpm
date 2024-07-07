package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PsychicDrain extends AttackSkill {
    public PsychicDrain() {
        this.setName("싸이킥 드레인");
        this.setDamage(150.0);
        this.setDelayByAttackSpeed(690L);
        this.setAttackCount(1L);
        this.setCooldown(3.0);
        this.setDotDuration(30000L);
        this.setInterval(500L);
        this.addFinalDamage(4.0);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
