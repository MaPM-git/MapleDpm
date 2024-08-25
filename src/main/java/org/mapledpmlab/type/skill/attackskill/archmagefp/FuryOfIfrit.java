package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuryOfIfrit extends AttackSkill {
    public FuryOfIfrit() {
        this.setName("퓨리 오브 이프리트");
        this.setDamage(440.0);
        this.setAttackCount(6L);
        this.setDotDuration(6000L);
        this.setInterval(180L);
        this.setLimitAttackCount(30L);
        this.setDelay(480L);
        this.setCooldown(75.0);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
