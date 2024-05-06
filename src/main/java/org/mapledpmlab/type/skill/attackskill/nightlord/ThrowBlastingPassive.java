package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThrowBlastingPassive extends AttackSkill {
    public ThrowBlastingPassive() {
        this.setName("스로우 블래스팅(패시브)");
        this.setAttackCount(5L);
        this.setCooldown(10.0);
        this.setDamage(1045.0);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.7);       // 쉐도우 파트너
        this.setApplyFinalAttack(true);
    }
}
