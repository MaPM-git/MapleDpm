package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Peacemaker extends AttackSkill {
    public Peacemaker() {
        this.setName("피스메이커");
        this.setDamage(770.0);
        this.setAttackCount(4L);
        this.setCooldown(10.0);
        this.setDotDuration(10000L);
        this.setInterval(350L);
        this.setLimitAttackCount(12L);
        this.setRelatedSkill(new PeacemakerDelay());
        this.addFinalDamage(1.6);       // 코어강화
    }
}
