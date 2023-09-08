package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MistralSpringNormal extends AttackSkill {
    public MistralSpringNormal() {
        this.setName("미스트랄 스프링(정령의 기운)");
        this.setAttackCount(1L);
        this.setDamage(6600.0);
        this.setLimitAttackCount(9L * 13);
        this.setDotDuration(20000L);
        this.setInterval(170L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new MistralSpringExcited());
    }
}
