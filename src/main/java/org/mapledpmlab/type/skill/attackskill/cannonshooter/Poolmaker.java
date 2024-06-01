package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Poolmaker extends AttackSkill {
    public Poolmaker() {
        this.setName("풀 메이커");
        this.setDamage(1540.0);
        this.setAttackCount(3 * 3L);    // 벅 샷
        this.setDotDuration(35000L);
        this.setInterval(1080L);
        this.setLimitAttackCount(30L);
        this.addFinalDamage(0.45);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
