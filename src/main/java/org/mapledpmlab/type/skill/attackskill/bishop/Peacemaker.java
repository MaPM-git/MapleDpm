package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Peacemaker extends AttackSkill {
    public Peacemaker() {
        this.setName("피스메이커");
        this.setDamage(770.0);
        this.setAttackCount(4L);
        this.setCooldown(10.0);
        this.setDelay(750L);
        this.setDotDuration(10000L);
        this.setInterval(350L);
        this.setLimitAttackCount(3L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new PeacemakerFinish());
    }
}
