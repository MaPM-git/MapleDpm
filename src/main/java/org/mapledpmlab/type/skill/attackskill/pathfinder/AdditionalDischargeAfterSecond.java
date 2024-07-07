package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdditionalDischargeAfterSecond extends AttackSkill {
    public AdditionalDischargeAfterSecond() {
        this.setName("에디셔널 디스차지(첫타 이후)");
        this.setAttackCount(3L);
        this.setDamage(275.0);
        this.setProp(55L);              // 카디널 포스-에디셔널 인핸스
        this.setDotDuration(2000L);
        this.setInterval(100L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(0.7);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addCriticalP(5.0);
    }
}
