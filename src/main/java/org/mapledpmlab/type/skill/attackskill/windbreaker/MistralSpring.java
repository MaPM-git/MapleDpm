package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MistralSpring extends AttackSkill {
    public MistralSpring() {
        this.setName("미스트랄 스프링");
        this.setAttackCount(10L);
        this.setCooldown(360.0);
        this.setDamage(2400.0);
        this.setLimitAttackCount(9L);
        this.setDotDuration(4560L);
        this.setInterval(506L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new MistralSpringDelay());
    }
}
