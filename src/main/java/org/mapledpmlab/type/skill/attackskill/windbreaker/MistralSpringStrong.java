package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MistralSpringStrong extends AttackSkill {
    public MistralSpringStrong() {
        this.setName("미스트랄 스프링(거센 정령의 기운)");
        this.setAttackCount(7L);
        this.setDamage(1275.0);
        this.setLimitAttackCount(9L * 3);
        this.setDotDuration(20000L);
        this.setInterval(700L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
    }
}
