package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdventOfGods extends AttackSkill {
    public AdventOfGods() {
        this.setName("선기 : 강림 괴력난신(신들의 강림)");
        this.setDamage(2200.0);
        this.setAttackCount(15L);
        this.setDelay(3780L);
        this.setDotDuration(3780L);
        this.setInterval(3780L / 6);
        this.setLimitAttackCount(6L);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
