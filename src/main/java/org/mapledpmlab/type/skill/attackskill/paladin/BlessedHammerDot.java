package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlessedHammerDot extends AttackSkill {
    public BlessedHammerDot() {
        this.setName("블래스드 해머");
        this.setAttackCount(4L);
        this.setDamage(1155.0);
        this.setDotDuration(30000L);
        this.setInterval(600L);
        this.setFinalDamage(1.6);   // 코어 강화
    }
}
