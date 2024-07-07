package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdditionalBlastAfterSecond extends AttackSkill {
    public AdditionalBlastAfterSecond() {
        this.setName("에디셔널 블래스트(첫타 이후)");
        this.setAttackCount(3L);
        this.setDamage(330.0);
        this.setProp(60L);
        this.setDotDuration(2000L);
        this.setInterval(100L);
        this.setLimitAttackCount(2L);
        this.addFinalDamage(0.7);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
