package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MistralSpringStrong extends AttackSkill {
    public MistralSpringStrong() {
        this.setName("미스트랄 스프링(거센 정령의 기운)");
        this.setAttackCount(1L);
        this.setDamage(10200.0);
        this.setLimitAttackCount(9L * 3);
        this.setDotDuration(20000L);
        this.setInterval(700L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
