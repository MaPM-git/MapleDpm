package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuryOfIfritOrigin extends AttackSkill {
    public FuryOfIfritOrigin() {
        this.setName("퓨리 오브 이프리트(6차)");
        this.setDamage(440.0);
        this.setAttackCount(6L);
        this.setDotDuration(7560L);
        this.setInterval(180L);
        this.setLimitAttackCount(42L);
        this.setDelay(480L);
        this.setCooldown(75.0);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
