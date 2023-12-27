package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MegaSmasherReinforce extends AttackSkill {
    public MegaSmasherReinforce() {
        this.setName("메가 스매셔(강화)");
        this.setAttackCount(6L * 2);
        this.setDamage(660.0);
        this.setDotDuration(8000L);
        this.setInterval(88L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.addFinalDamage(0.85);          // 버추얼 프로텍션
    }
}
