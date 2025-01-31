package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UltimateBPM extends AttackSkill {
    public UltimateBPM() {
        this.setName("얼티메이트-B.P.M");
        this.setDamage(310.0);
        this.setAttackCount(7L);
        this.setDotDuration(720000L);
        this.setInterval(600L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
