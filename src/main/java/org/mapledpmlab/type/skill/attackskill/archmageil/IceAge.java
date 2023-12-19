package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IceAge extends AttackSkill {
    public IceAge() {
        this.setName("아이스 에이지");
        this.setDamage(1100.0);
        this.setAttackCount(10L);
        this.setCooldown(60.0);
        this.setDelay(870L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.6);           // 코어강화
    }
}
