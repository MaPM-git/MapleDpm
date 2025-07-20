package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MegaSmasher extends AttackSkill {
    public MegaSmasher() {
        this.setName("메가 스매셔");
        this.setAttackCount(6L * 2);
        this.setDamage(440.0);
        this.setDelay(120L * 76 + 180);
        this.setDotDuration(120L * 76);
        this.setInterval(120L);
        this.setLimitAttackCount(76L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.addFinalDamage(0.85);          // 버추얼 프로텍션
    }
}
