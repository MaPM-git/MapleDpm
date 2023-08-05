package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SilhouetteMirage extends AttackSkill {
    public SilhouetteMirage() {
        this.setName("실루엣 미라주");
        this.setAttackCount(3L);
        this.setDamage(880.0);
        this.setDotDuration(60000L);
        this.setInterval(100L);
        this.setLimitAttackCount(5L);
        this.setFinalDamage(1.6);       // 코어강화
    }
}
