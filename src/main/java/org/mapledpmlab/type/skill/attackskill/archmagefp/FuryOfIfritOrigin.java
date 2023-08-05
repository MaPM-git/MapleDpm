package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuryOfIfritOrigin extends AttackSkill {
    public FuryOfIfritOrigin() {
        this.setName("퓨리 오브 이프리트(6차 이후)");
        this.setDamage(440.0);
        this.setAttackCount(6L);
        this.setDotDuration(8000L);
        this.setInterval(240L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyFinalAttack(true);
    }
}
