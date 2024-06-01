package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MistralSpringExcited extends AttackSkill {
    public MistralSpringExcited() {
        this.setName("미스트랄 스프링(신난 정령의 기운)");
        this.setAttackCount(6L);
        this.setDamage(1440.0);
        this.setLimitAttackCount(9L * 5);
        this.setDotDuration(20000L);
        this.setInterval(420L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new MistralSpringStrong());
    }
}
