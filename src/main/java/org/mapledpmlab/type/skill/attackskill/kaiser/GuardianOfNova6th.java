package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GuardianOfNova6th extends AttackSkill {
    public GuardianOfNova6th() {
        this.setName("가디언 오브 노바(6대)");
        this.setDamage(900.0);
        this.setAttackCount(4L);
        this.setDotDuration(45000L);
        this.setInterval(990L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new GuardianOfNova15th());
    }
}
