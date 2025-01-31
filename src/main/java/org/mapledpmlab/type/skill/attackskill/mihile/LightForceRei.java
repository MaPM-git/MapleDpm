package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightForceRei extends AttackSkill {
    public LightForceRei() {
        this.setName("라이트 포스레이");
        this.setApplyFinalAttack(true);
        this.setAttackCount(15L);
        this.setDamage(2055.0);
        this.setDelayByAttackSpeed(930L);
        this.addFinalDamage(1.6);       // 코어강화
        this.getMultiAttackInfo().add(450L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
