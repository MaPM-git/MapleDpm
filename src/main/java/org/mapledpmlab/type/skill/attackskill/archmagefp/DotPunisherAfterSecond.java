package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DotPunisherAfterSecond extends AttackSkill {
    public DotPunisherAfterSecond() {
        this.setName("도트 퍼니셔(첫타 이후)");
        this.setDamage(850.0);
        this.setAttackCount(5L);
        this.setDotDuration(2400L);
        this.setInterval(100L);
        this.setLimitAttackCount(23L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(0.55);
        this.setApplyFinalAttack(true);
    }
}
