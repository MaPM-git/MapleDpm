package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IceAgeDot extends AttackSkill {
    public IceAgeDot() {
        this.setName("아이스 에이지(얼어붙은 지면)");
        this.setDamage(275.0);
        this.setAttackCount(3L);
        this.setCooldown(60.0);
        this.setDotDuration(15000L);
        this.setInterval(800L);
        this.setRelatedSkill(new IceAge());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);           // 코어강화
    }
}
