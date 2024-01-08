package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BaptismOfLightAndDarkness extends AttackSkill {
    public BaptismOfLightAndDarkness() {
        this.setName("빛과 어둠의 세례");
        this.setDamage(990.0);
        this.setAttackCount(7L);
        this.setDotDuration(30000L);
        this.setInterval(185L);
        this.setLimitAttackCount(13L);
        this.setRelatedSkill(new BaptismOfLightAndDarknessDelay());
        this.addFinalDamage(1.6);       // 코어 강화
        this.setCooldown(45.0);
    }
}
