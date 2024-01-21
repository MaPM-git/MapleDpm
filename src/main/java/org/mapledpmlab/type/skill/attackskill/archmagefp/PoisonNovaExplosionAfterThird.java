package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonNovaExplosionAfterThird extends AttackSkill {
    public PoisonNovaExplosionAfterThird() {
        this.setName("포이즌 노바(폭발 3타 이후)");
        this.setDamage(495.0);
        this.setAttackCount(108L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.addFinalDamage(0.5);
        this.setApplyFinalAttack(true);
    }
}
