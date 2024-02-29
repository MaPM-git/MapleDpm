package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GuardianOfNova15th extends AttackSkill {
    public GuardianOfNova15th() {
        this.setName("가디언 오브 노바(15대)");
        this.setDamage(550.0);
        this.setAttackCount(6L);
        this.setDotDuration(45000L);
        this.setInterval(1260L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setRelatedSkill(new GuardianOfNova27th());
    }
}
