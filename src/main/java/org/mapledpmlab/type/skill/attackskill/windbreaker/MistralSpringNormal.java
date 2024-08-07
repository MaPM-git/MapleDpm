package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MistralSpringNormal extends AttackSkill {
    public MistralSpringNormal() {
        this.setName("미스트랄 스프링(정령의 기운)");
        this.setAttackCount(5L);
        this.setDamage(1320.0);
        this.setLimitAttackCount(9L * 13);
        this.setDotDuration(20000L);
        this.setInterval(170L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setRelatedSkill(new MistralSpringExcited());
    }
}
