package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThrowBlastingActive extends AttackSkill {
    public ThrowBlastingActive() {
        this.setName("스로우 블래스팅(액티브)");
        this.setAttackCount(15L);
        this.setDamage(1045.0);
        this.setDelay(1L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
