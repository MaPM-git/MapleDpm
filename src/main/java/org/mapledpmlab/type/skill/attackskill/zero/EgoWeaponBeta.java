package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EgoWeaponBeta extends AttackSkill {
    public EgoWeaponBeta() {
        this.setName("에고 웨폰(베타)");
        this.setAttackCount(9L);
        this.setDamage(500.0);
        this.setCooldown(15.0);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
