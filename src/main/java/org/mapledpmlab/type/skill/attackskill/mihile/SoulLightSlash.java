package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoulLightSlash extends AttackSkill {
    public SoulLightSlash() {
        this.setName("소울 라이트 슬래시");
        this.setApplyFinalAttack(true);
        this.setAttackCount(12L);
        this.setDamage(970.0);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(1.6);       // 코어강화
    }
}
