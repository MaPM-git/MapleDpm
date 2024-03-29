package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Resonate extends AttackSkill {
    public Resonate() {
        this.setName("레조네이트");
        this.setDamage(165.0 + 203);
        this.setAttackCount(3L);
        this.setDotDuration(660L * 4);
        this.setInterval(660L);
        this.setLimitAttackCount(4L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
