package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MarkOfPhantom extends AttackSkill {
    public MarkOfPhantom() {
        this.setName("마크 오브 팬텀(궤적)");
        this.setAttackCount(6L);
        this.setDamage(660.0);
        this.setDotDuration(525L);
        this.setInterval(75L);
        this.setLimitAttackCount(7L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
